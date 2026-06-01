package com.sbnz.model;

import java.util.ArrayList;
import java.util.List;

public class ChildProfile {
    private Long childId;
    private int ageInMonths;
    private final List<String> riskFactors = new ArrayList<>();

    public ChildProfile() {
    }

    public ChildProfile(Long childId, int ageInMonths) {
        this.childId = childId;
        this.ageInMonths = ageInMonths;
    }

    public Long getChildId() {
        return childId;
    }

    public void setChildId(Long childId) {
        this.childId = childId;
    }

    public int getAgeInMonths() {
        return ageInMonths;
    }

    public void setAgeInMonths(int ageInMonths) {
        this.ageInMonths = ageInMonths;
    }

    public List<String> getRiskFactors() {
        return riskFactors;
    }
}
