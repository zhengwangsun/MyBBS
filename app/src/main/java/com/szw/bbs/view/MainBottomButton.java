package com.szw.bbs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.szw.bbs.utils.StringUtils;

import sun.com.mybbs.R;

/**
 * Created by sun on 2016/12/12.
 */

public class MainBottomButton extends LinearLayout {

    private TextView mTextView;
    private ImageView mIcon;
    private TextView mNew;
    private Context mContext;
    private int mIconSelected = -1;
    private int mIconDefault = -1;


    public MainBottomButton(Context pContext, AttributeSet pAttrs) {
        super(pContext, pAttrs);
        init(pContext);
    }

    public MainBottomButton(Context pContext) {
        super(pContext);
        init(pContext);
    }

    public MainBottomButton(Context pContext, AttributeSet pAttrs, int pDefStyle) {
        super(pContext, pAttrs, pDefStyle);
        init(pContext);
    }

    private void init(Context context) {
        mContext = context;
        LayoutInflater.from(context).inflate(R.layout.view_bottom_button, this);
        mTextView = (TextView) findViewById(R.id.button_tv);
        mIcon = (ImageView)  findViewById(R.id.button_iv);
        mNew = (TextView) findViewById(R.id.button_new);
    }

    public void setIconResSelected(int rid) {
        if (rid > 0) {
            mIconSelected = rid;
        }
        mIcon.setImageResource(mIconSelected);
    }

    public void setIconResDefault(int rid) {
        if (rid > 0) {
            mIconDefault = rid;
        }
        mIcon.setImageResource(mIconDefault);
    }

    public void setText(int rid) {
        if (rid > 0) {
            mTextView.setText(mContext.getText(rid));
        }
    }

    public void setNewCount(int count) {
        if (count <= 0) {
            mNew.setText("");
            mNew.setVisibility(GONE);
        } else {
            mNew.setText("");
            mNew.setVisibility(VISIBLE);
        }
    }

    public void setNewShow(boolean isShow) {
        mNew.setVisibility(isShow ? VISIBLE : GONE);
    }

    public void setText(String text) {
        if (!StringUtils.isEmpty(text)) {
            mTextView.setText(text);
        }
    }

    public void setSelected(boolean isSelected) {
        if (isSelected) {
            mTextView.setTextColor(mContext.getResources().getColor(R.color.green));
            mIcon.setImageResource(mIconSelected);
        } else {
            mTextView.setTextColor(mContext.getResources().getColor(R.color.dark_gray));
            mIcon.setImageResource(mIconDefault);
        }
    }
}
