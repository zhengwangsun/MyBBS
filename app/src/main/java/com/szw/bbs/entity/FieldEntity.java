package com.szw.bbs.entity;

/**
 * Created by sun on 2016/12/12.
 */

public class FieldEntity {
    private String fieldId;
    private String fieldName;

    public FieldEntity(String fieldName, String fieldId) {
        this.fieldName = fieldName;
        this.fieldId = fieldId;
    }

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
}
