package com.szw.bbs.bg;

import com.szw.bbs.entity.AnswerEntity;
import com.szw.bbs.entity.AttentionProblemEntity;
import com.szw.bbs.entity.AttentionUserEntity;
import com.szw.bbs.entity.FieldEntity;
import com.szw.bbs.entity.ProblemEntity;
import com.szw.bbs.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sun on 2016/12/12.
 */

public class CommonCache {
    public static UserEntity myUserEntity;
    public static List<ProblemEntity> sProblemList = new ArrayList<>();
    public static List<AnswerEntity> sAnswerList = new ArrayList<>();
    public static List<AttentionProblemEntity> sAttentionProblemList = new ArrayList<>();
    public static List<AttentionUserEntity> sAttentionUserList = new ArrayList<>();
    public static List<FieldEntity> sFieldList = new ArrayList<>();

    public static void init(){
        myUserEntity = new UserEntity("sun","sunzhengwang");

        ProblemEntity problemEntity;
        //problemEntity = new ProblemEntity("")
    }
}
