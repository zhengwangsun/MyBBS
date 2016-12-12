package com.szw.bbs.entity;

/**
 * Created by sun on 2016/12/12.
 */

public class AnswerEntity {
    private String problemId;
    private String answerDesc;
    private String userId;

    public AnswerEntity(String problemId, String answerDesc, String userId) {
        this.problemId = problemId;
        this.answerDesc = answerDesc;
        this.userId = userId;
    }

    public String getProblemId() {
        return problemId;
    }

    public void setProblemId(String problemId) {
        this.problemId = problemId;
    }

    public String getAnswerDesc() {
        return answerDesc;
    }

    public void setAnswerDesc(String answerDesc) {
        this.answerDesc = answerDesc;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
