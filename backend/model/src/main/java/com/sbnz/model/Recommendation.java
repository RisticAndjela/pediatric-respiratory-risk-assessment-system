package com.sbnz.model;

public class Recommendation {
    private Long childId;
    private String action;
    private String explanation;

    public Recommendation() {
    }

    public Recommendation(Long childId, String action, String explanation) {
        this.childId = childId;
        this.action = action;
        this.explanation = explanation;
    }

    public Long getChildId() {
        return childId;
    }

    public String getAction() {
        return action;
    }

    public String getExplanation() {
        return explanation;
    }

    @Override
    public String toString() {
        return action + " -> " + explanation;
    }
}
