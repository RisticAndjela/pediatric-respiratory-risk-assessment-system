package com.sbnz.model;

public class SignalCategoryLink {
    private String childType;
    private String parentCategory;

    public SignalCategoryLink() {
    }

    public SignalCategoryLink(String childType, String parentCategory) {
        this.childType = childType;
        this.parentCategory = parentCategory;
    }

    public String getChildType() {
        return childType;
    }

    public String getParentCategory() {
        return parentCategory;
    }
}
