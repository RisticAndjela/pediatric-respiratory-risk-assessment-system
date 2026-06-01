package com.sbnz.service;

import com.sbnz.model.ChildProfile;
import com.sbnz.model.ClinicalSignal;
import com.sbnz.model.HydrationIntakeEvent;
import com.sbnz.model.Recommendation;
import com.sbnz.model.RespiratoryAssessmentEvent;
import com.sbnz.service.drools.RespiratoryKieSessionFactory;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Collection;

public class Application {

    public static void main(String[] args) {
        KieSession ksession = RespiratoryKieSessionFactory.createSession();

        // this scenario is simple on purpose so the defense story is clear
        ChildProfile child = new ChildProfile(1L, 10);
        RespiratoryAssessmentEvent first = new RespiratoryAssessmentEvent(1L, Date.from(LocalDateTime.now().minusHours(2).atZone(ZoneId.systemDefault()).toInstant()), 54, 95, true, false);
        RespiratoryAssessmentEvent second = new RespiratoryAssessmentEvent(1L, Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()), 58, 94, true, true);
        HydrationIntakeEvent hydration = new HydrationIntakeEvent(1L, 60, true);

        ksession.insert(child);
        ksession.insert(first);
        ksession.insert(second);
        ksession.insert(hydration);

        int fired = ksession.fireAllRules();
        System.out.println("rules fired: " + fired);

        System.out.println("\nclinical signals");
        Collection<ClinicalSignal> signals = (Collection<ClinicalSignal>) ksession.getObjects(o -> o instanceof ClinicalSignal);
        for (ClinicalSignal signal : signals) {
            System.out.println("- " + signal);
        }

        System.out.println("\nrecommendations");
        Collection<Recommendation> recs = (Collection<Recommendation>) ksession.getObjects(o -> o instanceof Recommendation);
        for (Recommendation recommendation : recs) {
            System.out.println("- " + recommendation);
        }

        System.out.println("\nquery isSafeForHomeMonitoring");
        QueryResults safety = ksession.getQueryResults("isSafeForHomeMonitoring", 1L);
        System.out.println("rows: " + safety.size());

        System.out.println("\nquery getEscalationReasons");
        QueryResults reasons = ksession.getQueryResults("getEscalationReasons", 1L, org.kie.api.runtime.rule.Variable.v, org.kie.api.runtime.rule.Variable.v);
        for (QueryResultsRow row : reasons) {
            System.out.println("- " + row.get("$type") + ": " + row.get("$reason"));
        }

        System.out.println("\nquery getRequiredAction");
        QueryResults action = ksession.getQueryResults("getRequiredAction", 1L, org.kie.api.runtime.rule.Variable.v, org.kie.api.runtime.rule.Variable.v);
        for (QueryResultsRow row : action) {
            System.out.println("- action: " + row.get("$action") + " | explanation: " + row.get("$explanation"));
        }

        ksession.dispose();
    }
}


