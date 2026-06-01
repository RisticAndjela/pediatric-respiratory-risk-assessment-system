package com.sbnz.model;

public class ClinicalSignal {
    private Long childId;
    private String type;
    private String reason;

    public ClinicalSignal() {
    }

    public ClinicalSignal(Long childId, String type, String reason) {
        this.childId = childId;
        this.type = type;
        this.reason = reason;
    }

    public Long getChildId() {
        return childId;
    }

    public String getType() {
        return type;
    }

    public String getReason() {
        return reason;
    }

    @Override
    public String toString() {
        return type + " -> " + reason;
    }
}
