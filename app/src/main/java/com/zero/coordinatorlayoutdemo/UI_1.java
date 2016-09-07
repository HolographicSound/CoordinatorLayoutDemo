package com.zero.coordinatorlayoutdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.zero.coordinatorlayoutdemo.adapter.MTabPaperAdapter;
import com.zero.coordinatorlayoutdemo.fragment.ContextFrag;

import java.util.ArrayList;

/**
 * Created by HJF on 2016/9/5.
 * http://blog.csdn.net/qq_18669217
 */
public class UI_1 extends AppCompatActivity {

    private ViewPager viewPager;
    private Toolbar toolbar;
    private TabLayout tabLayout;

    private ArrayList<String> tabTexts = new ArrayList<>();
    private ArrayList<Fragment> mFragments = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_ui1);
        setSupportActionBar(toolbar);

        initView();
        initData();


        MTabPaperAdapter adapter = new MTabPaperAdapter(getSupportFragmentManager(), tabTexts, mFragments);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(3);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initData() {
        tabTexts.add("tab1");
        tabTexts.add("tab2");
        tabTexts.add("tab3");
        mFragments.add(ContextFrag.newInstance("tab1"));
        mFragments.add(ContextFrag.newInstance("tab2"));
        mFragments.add(ContextFrag.newInstance("tab3"));
    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tableLayout);
    }
}
