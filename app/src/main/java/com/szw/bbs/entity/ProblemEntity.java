package com.szw.bbs.entity;

/**
 * Created by sun on 2016/12/12.
 */

public class ProblemEntity {
    private String problemId;
    private String problemName;
    private String problemDesc;
    private String userId;

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProblemDesc() {
        return problemDesc;
    }

    public void setProblemDesc(String problemDesc) {
        this.problemDesc = problemDesc;
    }

    public String getProblemName() {
        return problemName;
    }

    public void setProblemName(String problemName) {
        this.problemName = problemName;
    }

    public String getProblemId() {
        return problemId;
    }

    public void setProblemId(String problemId) {
        this.problemId = problemId;
    }

    private String fieldId;

    public ProblemEntity(String problemName, String problemId, String problemDesc, String userId, String fieldId) {
        this.problemName = problemName;
        this.problemId = problemId;
        this.problemDesc = problemDesc;
        this.userId = userId;
        this.fieldId = fieldId;
    }
}
