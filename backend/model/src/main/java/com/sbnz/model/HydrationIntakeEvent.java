package com.sbnz.model;

public class HydrationIntakeEvent {
    private Long childId;
    private int intakePercent;
    private boolean poorFeeding;

    public HydrationIntakeEvent() {
    }

    public HydrationIntakeEvent(Long childId, int intakePercent, boolean poorFeeding) {
        this.childId = childId;
        this.intakePercent = intakePercent;
        this.poorFeeding = poorFeeding;
    }

    public Long getChildId() {
        return childId;
    }

    public int getIntakePercent() {
        return intakePercent;
    }

    public boolean isPoorFeeding() {
        return poorFeeding;
    }
}
