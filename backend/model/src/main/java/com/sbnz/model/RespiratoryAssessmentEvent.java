package com.sbnz.model;

import java.util.Date;

public class RespiratoryAssessmentEvent {
    private Long childId;
    private Date time;
    private int respiratoryRate;
    private int spo2;
    private boolean chestIndrawing;
    private boolean grunting;
    private boolean apnea;
    private boolean cyanosis;

    public RespiratoryAssessmentEvent() {
    }

    public RespiratoryAssessmentEvent(Long childId, Date time, int respiratoryRate, int spo2, boolean chestIndrawing, boolean grunting) {
        this(childId, time, respiratoryRate, spo2, chestIndrawing, grunting, false, false);
    }

    public RespiratoryAssessmentEvent(Long childId, Date time, int respiratoryRate, int spo2, boolean chestIndrawing, boolean grunting, boolean apnea, boolean cyanosis) {
        this.childId = childId;
        this.time = time;
        this.respiratoryRate = respiratoryRate;
        this.spo2 = spo2;
        this.chestIndrawing = chestIndrawing;
        this.grunting = grunting;
        this.apnea = apnea;
        this.cyanosis = cyanosis;
    }

    public Long getChildId() {
        return childId;
    }

    public Date getTime() {
        return time;
    }

    public int getRespiratoryRate() {
        return respiratoryRate;
    }

    public int getSpo2() {
        return spo2;
    }

    public boolean isChestIndrawing() {
        return chestIndrawing;
    }

    public boolean isGrunting() {
        return grunting;
    }

    public boolean isApnea() {
        return apnea;
    }

    public boolean isCyanosis() {
        return cyanosis;
    }
}
