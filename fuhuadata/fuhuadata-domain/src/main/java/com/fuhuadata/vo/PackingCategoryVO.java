package com.fuhuadata.vo;

/**
 * 包材目录view
 * Created by intanswer on 2017/3/2.
 */
public class PackingCategoryVO {
    private String parentId;
    private String parentName;
    private String childId;
    private String childName;


    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getChildId() {
        return childId;
    }

    public void setChildId(String childId) {
        this.childId = childId;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }
}
