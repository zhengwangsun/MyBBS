package com.szw.bbs.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.szw.bbs.ui.attention.AttentionFragment;
import com.szw.bbs.ui.home.HomeFragment;
import com.szw.bbs.ui.mine.MineFragment;
import com.szw.bbs.view.MainBottomButton;

import sun.com.mybbs.R;

/**
 * Created by sun on 2016/12/12.
 */

public class MainTabActivity extends FragmentActivity {
    private static final String TAG = "MainTabActivity";

    private static final int FRAGMENT_SIZE = 3;
    protected static final String TAG_MINE = "fragment.tag.mine";
    protected static final String TAG_ATTENTION = "fragment.tag.attention";
    protected static final String TAG_HOME = "fragment.tag.home";
    protected static final String TAG_ARRAY[] = {TAG_HOME, TAG_ATTENTION, TAG_MINE};
    private Fragment mFragments[] = new Fragment[FRAGMENT_SIZE];
    public static final int FRAGMENT_INDEX_HOME = 0;
    public static final int FRAGMENT_INDEX_ATTENTION = 1;
    public static final int FRAGMENT_INDEX_MINE = 2;


    public static final boolean DEBUG = true;
    
    private View.OnClickListener homeOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FragmentManager fm = getSupportFragmentManager();
            Fragment homeBaseFragment = fm.findFragmentByTag(TAG_HOME);
            FragmentTransaction ft = fm.beginTransaction();
            hideOtherFragments(ft, homeBaseFragment);
            if (homeBaseFragment == null) {
                if (DEBUG) {
                    Log.v(TAG, "homeOnClick homeBaseFragment == null, get & replace");
                }
                homeBaseFragment = getFragment(FRAGMENT_INDEX_HOME);
                ft.add(R.id.fl_content, homeBaseFragment, TAG_HOME);
            } else {
                if (DEBUG) {
                    Log.v(TAG, "homeOnClick homeBaseFragment show");
                }
                ft.show(homeBaseFragment);
            }

            ft.commitAllowingStateLoss();
            setButton(v);
        }
    };

    private View.OnClickListener diagnosisOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            Fragment colleaguesBaseFragment = fm.findFragmentByTag(TAG_ATTENTION);
            hideOtherFragments(ft, colleaguesBaseFragment);
            if (colleaguesBaseFragment == null) {
                if (DEBUG) {
                    Log.v(TAG, "colleagueOnClick colleagueBaseFragment == null, get & replace");
                }
                colleaguesBaseFragment = getFragment(FRAGMENT_INDEX_ATTENTION);
                ft.add(R.id.fl_content, colleaguesBaseFragment, TAG_ATTENTION);
            } else {
                if (DEBUG) {
                    Log.v(TAG, "colleagueOnClick colleagueBaseFragment show");
                }
                ft.show(colleaguesBaseFragment);
            }
            ft.commitAllowingStateLoss();
            setButton(v);
        }
    };

    private View.OnClickListener mineOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            Fragment mineBaseFragment = fm.findFragmentByTag(TAG_MINE);
            hideOtherFragments(ft, mineBaseFragment);
            if (mineBaseFragment == null) {
                mineBaseFragment = getFragment(FRAGMENT_INDEX_MINE);
                ft.add(R.id.fl_content, mineBaseFragment, TAG_MINE);
            } else {
                ft.show(mineBaseFragment);
            }
            ft.commitAllowingStateLoss();
            setButton(v);
        }
    };
    private Context mContext;
    private MainBottomButton mHome, mMine, mDiag;
    private View currentButton;
    private View avosNetStatus;
    private LinearLayout buttomBarGroup;

    private void switchTab(int index ){
        if (FRAGMENT_INDEX_HOME == index){
            if (mHome != null) {
                mHome.performClick();
            }
        }else if (FRAGMENT_INDEX_ATTENTION == index){
            if (mDiag != null) {
                mDiag.performClick();
            }
        }else {
            if (mMine != null) {
                mMine.performClick();
            }
        }


    }

//    private void regBroadCast(){
//        IntentFilter filter = new IntentFilter();
//        filter.addAction(Constant.BROADCAST_ACTION_SWITCH_MAIN_TAB);
//        mSwitchReceiver = new BroadcastReceiver() {
//            @Override
//            public void onReceive(Context context, Intent intent) {
//                if (intent != null){
//                    int index = intent.getIntExtra(FRAGMENT_INDEX,FRAGMENT_INDEX_HOME);
//                    switchTab(index);
//                }
//            }
//        };
//        LocalBroadcastManager.getInstance(MyApp.getInstance()).registerReceiver(mSwitchReceiver,filter);
//    }
//    private void unRegBroadcast(){
//        if (mSwitchReceiver != null){
//            LocalBroadcastManager.getInstance(MyApp.getInstance()).unregisterReceiver(mSwitchReceiver);
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_tab_base);
        mContext = this;


        findView();

        restoreFragmentData();

        init();

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }
    /**
     * 页面若发生了onRestoreInstanceState，需要恢复mFragments
     */
    private void restoreFragmentData() {
        FragmentManager fm = getSupportFragmentManager();
        if (fm.getFragments() == null || fm.getFragments().size() == 0) {
            return;
        }
        for (int i = 0; i < FRAGMENT_SIZE; i++) {
            String tag = TAG_ARRAY[i];
            Fragment frag = fm.findFragmentByTag(tag);
            if (frag != null) {
                mFragments[i] = frag;
            }
        }
    }


    @Override
    protected void onResume() {
        super.onResume();

        //升级预留
       /* mHome.postDelayed(new Runnable() {
            @Override
            public void run() {
                UpdateHelper.check(MainTabActivity.this, false, null);
            }
        }, 10000);*/
    }

    @Override
    protected void onStart() {
        super.onStart();
//        regBroadCast();
    }

    @Override
    protected void onStop() {
        super.onStop();
//        unRegBroadcast();
    }
    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void findView() {

        mHome = (MainBottomButton) findViewById(R.id.button_home);
        mHome.setIconResSelected(R.drawable.tabbar_home_on);
        mHome.setIconResDefault(R.drawable.tabbar_home_off);
        mHome.setText("首页");

        mMine = (MainBottomButton) findViewById(R.id.button_mine);
        mMine.setIconResSelected(R.drawable.tabbar_mine_on);
        mMine.setIconResDefault(R.drawable.tabbar_mine_off);
        mMine.setText("我的");

        mDiag = (MainBottomButton) findViewById(R.id.button_diagnosis);
        mDiag.setIconResSelected(R.drawable.tabbar_attention_on);
        mDiag.setIconResDefault(R.drawable.tabbar_attention_off);
        mDiag.setText("关注列表");

    }

    private void init() {
        mDiag.setOnClickListener(diagnosisOnClickListener);
        mHome.setOnClickListener(homeOnClickListener);
        mMine.setOnClickListener(mineOnClickListener);
        mHome.post(new Runnable() {
            @Override
            public void run() {
                mHome.performClick();
                mHome.setSelected(true);
                currentButton = mHome;
            }
        });
    }

    private Fragment getFragment(int index) {
        if (mFragments[index] == null) {
            switch (index) {
                case FRAGMENT_INDEX_HOME: {
                    mFragments[FRAGMENT_INDEX_HOME] = HomeFragment.newInstance(null, null);
                    break;
                }
                case FRAGMENT_INDEX_MINE: {
                    mFragments[FRAGMENT_INDEX_MINE] = MineFragment.newInstance(null, null);
                    break;
                }
                case FRAGMENT_INDEX_ATTENTION: {
                    mFragments[FRAGMENT_INDEX_ATTENTION] =  AttentionFragment.newInstance(null, null);
                    break;
                }
            }
        }
        return mFragments[index];
    }

    private void setButton(View v) {
        if (currentButton != null && currentButton.getId() != v.getId()) {
            currentButton = v;
            mHome.setSelected(v.getId() == mHome.getId());
            mMine.setSelected(v.getId() == mMine.getId());
            mDiag.setSelected(v.getId() == mDiag.getId());
        }
    }

    private void hideOtherFragments(FragmentTransaction ft, Fragment fragmentToShow) {
        for (int i = 0; i < FRAGMENT_SIZE; i++) {
            Fragment frag = mFragments[i];
            if (frag != null) {
                if (frag != fragmentToShow) {
                    if (!frag.isHidden()) {
                        ft.hide(frag);
                    }
                }
            }
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);

    }

}
