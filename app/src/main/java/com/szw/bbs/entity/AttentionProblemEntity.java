package com.szw.bbs.entity;

/**
 * Created by sun on 2016/12/12.
 */

public class AttentionProblemEntity {
    private String userId;
    private String problemId;

    public AttentionProblemEntity(String userId, String problemId) {
        this.userId = userId;
        this.problemId = problemId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProblemId() {
        return problemId;
    }

    public void setProblemId(String problemId) {
        this.problemId = problemId;
    }
}
