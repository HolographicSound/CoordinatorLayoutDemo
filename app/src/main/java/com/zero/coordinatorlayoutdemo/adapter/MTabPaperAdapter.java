/*
 * @(#) MTabPaperAdapter.java 2015/11/6.
 * CopyRight 2015 TaoYuanTn All Rights Reserved
 * @modify
 */
package com.zero.coordinatorlayoutdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HJF on 2016/9/5.
 * http://blog.csdn.net/qq_18669217
 */
public class MTabPaperAdapter extends FragmentPagerAdapter {
    private ArrayList<String> mTitles;
    private List<Fragment> mFragments;

    public MTabPaperAdapter(FragmentManager fm, ArrayList<String> mTitles, List<Fragment> mFragments) {
        super(fm);
        this.mTitles = mTitles;
        this.mFragments = mFragments;
    }

    @Override
    public Fragment getItem(int i) {
        return mFragments.get(i);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}
