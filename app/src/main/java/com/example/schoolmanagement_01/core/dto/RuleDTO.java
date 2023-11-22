package com.example.schoolmanagement_01.core.dto;

public class RuleDTO {
    private Integer id;

    private Integer parentId;

    private String ruleName;

    private Integer minusPoint;

    private String collectionCode;

    private String groupCode;

    public RuleDTO(Integer id,Integer parentId, String ruleName, Integer minusPoint) {
        this.id = id;
        this.ruleName = ruleName;
        this.minusPoint = minusPoint;
        this.parentId = parentId;
    }

    public RuleDTO(Integer id, Integer parentId, String ruleName, Integer minusPoint, String collectionCode, String groupCode) {
        this.id = id;
        this.parentId = parentId;
        this.ruleName = ruleName;
        this.minusPoint = minusPoint;
        this.collectionCode = collectionCode;
        this.groupCode = groupCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public Integer getMinusPoint() {
        return minusPoint;
    }

    public void setMinusPoint(Integer minusPoint) {
        this.minusPoint = minusPoint;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getCollectionCode() {
        return collectionCode;
    }

    public void setCollectionId(String collectionCode) {
        this.collectionCode = collectionCode;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }
}

