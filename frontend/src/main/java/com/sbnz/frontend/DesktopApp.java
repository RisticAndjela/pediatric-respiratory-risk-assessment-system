package com.sbnz.frontend;

import com.sbnz.model.ChildProfile;
import com.sbnz.model.ClinicalSignal;
import com.sbnz.model.HydrationIntakeEvent;
import com.sbnz.model.Recommendation;
import com.sbnz.model.RespiratoryAssessmentEvent;
import com.sbnz.frontend.drools.RespiratoryKieSessionFactory;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.kie.api.runtime.rule.Variable;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class DesktopApp {

    private final Map<Long, PatientCase> cases = new LinkedHashMap<>();
    private final Map<Long, List<String>> runHistory = new LinkedHashMap<>();
    private final DefaultListModel<Long> patientListModel = new DefaultListModel<>();

    private JTextField childIdField;
    private JTextField ageField;
    private JTextField rr1Field;
    private JTextField spo21Field;
    private JCheckBox chest1Box;
    private JCheckBox grunting1Box;
    private JCheckBox apnea1Box;
    private JCheckBox cyanosis1Box;

    private JTextField rr2Field;
    private JTextField spo22Field;
    private JCheckBox chest2Box;
    private JCheckBox grunting2Box;
    private JCheckBox apnea2Box;
    private JCheckBox cyanosis2Box;

    private JTextField intakeField;
    private JCheckBox poorFeedingBox;
    private JComboBox<String> modelSelector;
    private JTextArea outputArea;
    private JList<Long> patientList;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DesktopApp().createAndShowUI());
    }

    private void createAndShowUI() {
        JFrame frame = new JFrame("SBNZ Frontend - Patient Rule Tester");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1180, 760);

        JPanel formPanel = new JPanel(new GridLayout(0, 2, 8, 8));
        formPanel.setBorder(new TitledBorder("Patient Inputs"));

        childIdField = new JTextField("1");
        ageField = new JTextField("10");
        rr1Field = new JTextField("54");
        spo21Field = new JTextField("95");
        chest1Box = new JCheckBox("Chest indrawing event 1", true);
        grunting1Box = new JCheckBox("Grunting event 1", false);
        apnea1Box = new JCheckBox("Apnea event 1", false);
        cyanosis1Box = new JCheckBox("Cyanosis event 1", false);

        rr2Field = new JTextField("58");
        spo22Field = new JTextField("94");
        chest2Box = new JCheckBox("Chest indrawing event 2", true);
        grunting2Box = new JCheckBox("Grunting event 2", true);
        apnea2Box = new JCheckBox("Apnea event 2", false);
        cyanosis2Box = new JCheckBox("Cyanosis event 2", false);

        intakeField = new JTextField("60");
        poorFeedingBox = new JCheckBox("Poor feeding", true);

        modelSelector = new JComboBox<>(new String[]{
                "Standard preset",
                "Conservative preset",
                "High-risk preset"
        });

        addRow(formPanel, "Child ID", childIdField);
        addRow(formPanel, "Age in months", ageField);
        addRow(formPanel, "Event 1 RR (breaths/min)", rr1Field);
        addRow(formPanel, "Event 1 SpO2", spo21Field);
        addRow(formPanel, "Event 2 RR (breaths/min)", rr2Field);
        addRow(formPanel, "Event 2 SpO2", spo22Field);
        addRow(formPanel, "Hydration intake %", intakeField);
        addRow(formPanel, "Input model", modelSelector);

        formPanel.add(chest1Box);
        formPanel.add(grunting1Box);
        formPanel.add(apnea1Box);
        formPanel.add(cyanosis1Box);
        formPanel.add(chest2Box);
        formPanel.add(grunting2Box);
        formPanel.add(apnea2Box);
        formPanel.add(cyanosis2Box);
        formPanel.add(poorFeedingBox);
        formPanel.add(new JLabel(""));

        JButton applyPresetButton = new JButton("Apply Preset");
        applyPresetButton.addActionListener(e -> applyPreset());

        JButton savePatientButton = new JButton("Save/Update Patient");
        savePatientButton.addActionListener(e -> savePatientCase());

        JButton runSelectedButton = new JButton("Run Rules");
        runSelectedButton.addActionListener(e -> runSelectedPatient());

        JButton showHistoryButton = new JButton("Show History");
        showHistoryButton.addActionListener(e -> showHistoryForSelectedPatient());

        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 8, 8));
        buttonPanel.add(applyPresetButton);
        buttonPanel.add(savePatientButton);
        buttonPanel.add(runSelectedButton);
        buttonPanel.add(showHistoryButton);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 13));
        outputArea.setBorder(new EmptyBorder(10, 10, 10, 10));
        outputArea.setText("Select a patient and click Run Rules.\n");

        patientList = new JList<>(patientListModel);
        patientList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        patientList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                Long selectedId = patientList.getSelectedValue();
                if (selectedId != null) {
                    loadPatientCase(cases.get(selectedId));
                }
            }
        });

        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBorder(new TitledBorder("Saved Patients"));
        leftPanel.add(new JLabel("Click patient ID to load data"), BorderLayout.NORTH);
        leftPanel.add(new JScrollPane(patientList), BorderLayout.CENTER);

        JPanel topRight = new JPanel(new BorderLayout());
        topRight.setBorder(new EmptyBorder(8, 8, 8, 8));
        topRight.add(formPanel, BorderLayout.CENTER);
        topRight.add(buttonPanel, BorderLayout.SOUTH);

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.add(topRight, BorderLayout.NORTH);
        JScrollPane outputScroll = new JScrollPane(outputArea);
        outputScroll.setBorder(new TitledBorder("Rule Engine Output"));
        rightPanel.add(outputScroll, BorderLayout.CENTER);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        splitPane.setDividerLocation(260);
        frame.add(splitPane);

        loadDemoCases();
        if (patientListModel.isEmpty()) {
            savePatientCase();
        }
        patientList.setSelectedIndex(0);

        frame.setVisible(true);
    }

    private void addRow(JPanel panel, String label, java.awt.Component input) {
        panel.add(new JLabel(label));
        panel.add(input);
    }

    private void loadDemoCases() {
        Path path = Path.of("data", "demo-children.csv");
        if (!Files.exists(path)) {
            return;
        }
        try {
            List<String> lines = Files.readAllLines(path);
            for (int i = 1; i < lines.size(); i++) {
                String line = lines.get(i).trim();
                if (line.isEmpty()) continue;
                String[] p = line.split(",");
                if (p.length < 16) continue;
                PatientCase c = new PatientCase();
                c.childId = Long.parseLong(p[0].trim());
                c.ageInMonths = Integer.parseInt(p[1].trim());
                c.rr1 = Integer.parseInt(p[2].trim());
                c.spo21 = Integer.parseInt(p[3].trim());
                c.chest1 = Boolean.parseBoolean(p[4].trim());
                c.grunting1 = Boolean.parseBoolean(p[5].trim());
                c.apnea1 = Boolean.parseBoolean(p[6].trim());
                c.cyanosis1 = Boolean.parseBoolean(p[7].trim());
                c.rr2 = Integer.parseInt(p[8].trim());
                c.spo22 = Integer.parseInt(p[9].trim());
                c.chest2 = Boolean.parseBoolean(p[10].trim());
                c.grunting2 = Boolean.parseBoolean(p[11].trim());
                c.apnea2 = Boolean.parseBoolean(p[12].trim());
                c.cyanosis2 = Boolean.parseBoolean(p[13].trim());
                c.intakePercent = Integer.parseInt(p[14].trim());
                c.poorFeeding = Boolean.parseBoolean(p[15].trim());
                cases.put(c.childId, c);
                if (!patientListModel.contains(c.childId)) {
                    patientListModel.addElement(c.childId);
                }
            }
        } catch (Exception ignored) {
            // If demo file is malformed, app still starts with manual input.
        }
    }

    private void applyPreset() {
        String selected = (String) modelSelector.getSelectedItem();
        if ("Conservative preset".equals(selected)) {
            rr1Field.setText("42");
            spo21Field.setText("97");
            rr2Field.setText("40");
            spo22Field.setText("97");
            chest1Box.setSelected(false);
            grunting1Box.setSelected(false);
            apnea1Box.setSelected(false);
            cyanosis1Box.setSelected(false);
            chest2Box.setSelected(false);
            grunting2Box.setSelected(false);
            apnea2Box.setSelected(false);
            cyanosis2Box.setSelected(false);
            intakeField.setText("90");
            poorFeedingBox.setSelected(false);
        } else if ("High-risk preset".equals(selected)) {
            rr1Field.setText("62");
            spo21Field.setText("89");
            rr2Field.setText("68");
            spo22Field.setText("88");
            chest1Box.setSelected(true);
            grunting1Box.setSelected(true);
            apnea1Box.setSelected(true);
            cyanosis1Box.setSelected(false);
            chest2Box.setSelected(true);
            grunting2Box.setSelected(true);
            apnea2Box.setSelected(false);
            cyanosis2Box.setSelected(true);
            intakeField.setText("45");
            poorFeedingBox.setSelected(true);
        } else {
            rr1Field.setText("54");
            spo21Field.setText("95");
            rr2Field.setText("58");
            spo22Field.setText("94");
            chest1Box.setSelected(true);
            grunting1Box.setSelected(false);
            apnea1Box.setSelected(false);
            cyanosis1Box.setSelected(false);
            chest2Box.setSelected(true);
            grunting2Box.setSelected(true);
            apnea2Box.setSelected(false);
            cyanosis2Box.setSelected(false);
            intakeField.setText("60");
            poorFeedingBox.setSelected(true);
        }
    }

    private void savePatientCase() {
        try {
            PatientCase c = readCaseFromForm();
            cases.put(c.childId, c);
            if (!patientListModel.contains(c.childId)) {
                patientListModel.addElement(c.childId);
            }
            patientList.setSelectedValue(c.childId, true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Please enter valid numeric values.\n" + ex.getMessage());
        }
    }

    private void loadPatientCase(PatientCase c) {
        if (c == null) return;
        childIdField.setText(String.valueOf(c.childId));
        ageField.setText(String.valueOf(c.ageInMonths));
        rr1Field.setText(String.valueOf(c.rr1));
        spo21Field.setText(String.valueOf(c.spo21));
        chest1Box.setSelected(c.chest1);
        grunting1Box.setSelected(c.grunting1);
        apnea1Box.setSelected(c.apnea1);
        cyanosis1Box.setSelected(c.cyanosis1);

        rr2Field.setText(String.valueOf(c.rr2));
        spo22Field.setText(String.valueOf(c.spo22));
        chest2Box.setSelected(c.chest2);
        grunting2Box.setSelected(c.grunting2);
        apnea2Box.setSelected(c.apnea2);
        cyanosis2Box.setSelected(c.cyanosis2);

        intakeField.setText(String.valueOf(c.intakePercent));
        poorFeedingBox.setSelected(c.poorFeeding);
    }

    private void runSelectedPatient() {
        Long selectedId = patientList.getSelectedValue();
        if (selectedId == null) {
            JOptionPane.showMessageDialog(null, "Please save and select a patient first.");
            return;
        }
        PatientCase c = cases.get(selectedId);
        if (c == null) return;
        outputArea.setText("Running rules for patient " + selectedId + "...\n");
        try {
            String output = runRules(c);
            outputArea.setText(output);
            runHistory.computeIfAbsent(selectedId, id -> new ArrayList<>())
                    .add(LocalDateTime.now() + "\n" + output);
        } catch (Exception ex) {
            String errorText = "Rule execution failed:\n" + ex.getClass().getSimpleName() + ": " + ex.getMessage();
            outputArea.setText(errorText);
            JOptionPane.showMessageDialog(null, errorText, "Execution Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void showHistoryForSelectedPatient() {
        Long selectedId = patientList.getSelectedValue();
        if (selectedId == null) {
            JOptionPane.showMessageDialog(null, "Please select a patient first.");
            return;
        }
        List<String> history = runHistory.get(selectedId);
        if (history == null || history.isEmpty()) {
            outputArea.setText("No in-memory history yet for patient " + selectedId + ".\nRun rules at least once.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("In-memory run history for patient ").append(selectedId).append("\n\n");
        for (int i = 0; i < history.size(); i++) {
            sb.append("Run #").append(i + 1).append("\n");
            sb.append(history.get(i)).append("\n");
            sb.append("----------------------------------------\n");
        }
        outputArea.setText(sb.toString());
    }

    private PatientCase readCaseFromForm() {
        PatientCase c = new PatientCase();
        c.childId = Long.parseLong(childIdField.getText().trim());
        c.ageInMonths = Integer.parseInt(ageField.getText().trim());
        c.rr1 = Integer.parseInt(rr1Field.getText().trim());
        c.spo21 = Integer.parseInt(spo21Field.getText().trim());
        c.chest1 = chest1Box.isSelected();
        c.grunting1 = grunting1Box.isSelected();
        c.apnea1 = apnea1Box.isSelected();
        c.cyanosis1 = cyanosis1Box.isSelected();

        c.rr2 = Integer.parseInt(rr2Field.getText().trim());
        c.spo22 = Integer.parseInt(spo22Field.getText().trim());
        c.chest2 = chest2Box.isSelected();
        c.grunting2 = grunting2Box.isSelected();
        c.apnea2 = apnea2Box.isSelected();
        c.cyanosis2 = cyanosis2Box.isSelected();

        c.intakePercent = Integer.parseInt(intakeField.getText().trim());
        c.poorFeeding = poorFeedingBox.isSelected();
        return c;
    }

    private String runRules(PatientCase c) {
        KieSession ksession = RespiratoryKieSessionFactory.createSession();

        ChildProfile child = new ChildProfile(c.childId, c.ageInMonths);
        RespiratoryAssessmentEvent first = new RespiratoryAssessmentEvent(c.childId, Date.from(LocalDateTime.now().minusHours(2).atZone(ZoneId.systemDefault()).toInstant()), c.rr1, c.spo21, c.chest1, c.grunting1, c.apnea1, c.cyanosis1);
        RespiratoryAssessmentEvent second = new RespiratoryAssessmentEvent(c.childId, Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()), c.rr2, c.spo22, c.chest2, c.grunting2, c.apnea2, c.cyanosis2);
        HydrationIntakeEvent hydration = new HydrationIntakeEvent(c.childId, c.intakePercent, c.poorFeeding);

        ksession.insert(child);
        ksession.insert(first);
        ksession.insert(second);
        ksession.insert(hydration);

        int fired = ksession.fireAllRules();

        StringBuilder out = new StringBuilder();
        out.append("rules fired: ").append(fired).append("\n\n");

        out.append("clinical signals\n");
        Collection<ClinicalSignal> signals = (Collection<ClinicalSignal>) ksession.getObjects(o -> o instanceof ClinicalSignal);
        for (ClinicalSignal signal : signals) {
            out.append("- ").append(signal).append("\n");
        }

        out.append("\nrecommendations\n");
        Collection<Recommendation> recs = (Collection<Recommendation>) ksession.getObjects(o -> o instanceof Recommendation);
        for (Recommendation recommendation : recs) {
            out.append("- ").append(recommendation).append("\n");
        }

        out.append("\nquery isSafeForHomeMonitoring\n");
        QueryResults safety = ksession.getQueryResults("isSafeForHomeMonitoring", c.childId);
        out.append("rows: ").append(safety.size()).append("\n");

        out.append("\nquery getEscalationReasons\n");
        QueryResults reasons = ksession.getQueryResults("getEscalationReasons", c.childId, Variable.v, Variable.v);
        for (QueryResultsRow row : reasons) {
            out.append("- ").append(row.get("$type")).append(": ").append(row.get("$reason")).append("\n");
        }

        out.append("\nquery getHomeMonitoringBlockers\n");
        QueryResults blockers = ksession.getQueryResults("getHomeMonitoringBlockers", c.childId, Variable.v, Variable.v);
        for (QueryResultsRow row : blockers) {
            out.append("- blocker ").append(row.get("$blockerType")).append(": ").append(row.get("$blockerReason")).append("\n");
        }

        out.append("\nquery getRespiratoryCategories\n");
        QueryResults respiratoryCats = ksession.getQueryResults("getRespiratoryCategories", c.childId, Variable.v, Variable.v);
        for (QueryResultsRow row : respiratoryCats) {
            out.append("- respiratory ").append(row.get("$type")).append(": ").append(row.get("$reason")).append("\n");
        }

        out.append("\nquery getHydrationCategories\n");
        QueryResults hydrationCats = ksession.getQueryResults("getHydrationCategories", c.childId, Variable.v, Variable.v);
        for (QueryResultsRow row : hydrationCats) {
            out.append("- hydration ").append(row.get("$type")).append(": ").append(row.get("$reason")).append("\n");
        }

        out.append("\nquery getRequiredAction\n");
        QueryResults action = ksession.getQueryResults("getRequiredAction", c.childId, Variable.v, Variable.v);
        for (QueryResultsRow row : action) {
            out.append("- action: ").append(row.get("$action")).append(" | explanation: ").append(row.get("$explanation")).append("\n");
        }

        ksession.dispose();
        return out.toString();
    }

    private static class PatientCase {
        Long childId;
        int ageInMonths;
        int rr1;
        int spo21;
        boolean chest1;
        boolean grunting1;
        boolean apnea1;
        boolean cyanosis1;

        int rr2;
        int spo22;
        boolean chest2;
        boolean grunting2;
        boolean apnea2;
        boolean cyanosis2;

        int intakePercent;
        boolean poorFeeding;
    }
}


