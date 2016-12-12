package com.szw.bbs.entity;

/**
 * Created by sun on 2016/12/12.
 */

public class AttentionUserEntity {
    private String userIdMy;
    private String userIdAttention;

    public AttentionUserEntity(String userIdMy, String userIdAttention) {
        this.userIdMy = userIdMy;
        this.userIdAttention = userIdAttention;
    }

    public String getUserIdMy() {
        return userIdMy;
    }

    public void setUserIdMy(String userIdMy) {
        this.userIdMy = userIdMy;
    }

    public String getUserIdAttention() {
        return userIdAttention;
    }

    public void setUserIdAttention(String userIdAttention) {
        this.userIdAttention = userIdAttention;
    }
}
