package com.zero.coordinatorlayoutdemo;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Toast;

/**
 * Created by HJF on 2016/9/5.
 * http://blog.csdn.net/qq_18669217
 */
public class UI_2 extends AppCompatActivity {

    private static final float PERCENTAGE_TO_SHOW_TITLE_NAME = 0.9f;
    private static final float PERCENTAGE_TO_HIDE_PERSIONINFO = 0.3f;

    private AppBarLayout appBarLayout;
    private View personInfoName, personInfoprofessional, titleName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_ui2);
        appBarLayout = (AppBarLayout) findViewById(R.id.appbarLayout);
        titleName = findViewById(R.id.t_title_name);
        personInfoName = findViewById(R.id.person_info_name);
        personInfoprofessional = findViewById(R.id.person_info_professional);


        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                float totalScrollRange = appBarLayout.getTotalScrollRange();
                float percent = Math.abs(verticalOffset) / totalScrollRange;
                handleTitleName(percent);
                handlePersionInfo(percent);
            }
        });
    }


    private void handlePersionInfo(float percent) {
        if (percent > PERCENTAGE_TO_HIDE_PERSIONINFO && personInfoName.getVisibility() == View.VISIBLE) {
            personInfoName.setVisibility(View.INVISIBLE);
            personInfoprofessional.setVisibility(View.INVISIBLE);
        } else if (percent <= PERCENTAGE_TO_HIDE_PERSIONINFO && personInfoName.getVisibility() != View.VISIBLE) {
            personInfoName.setVisibility(View.VISIBLE);
            personInfoprofessional.setVisibility(View.VISIBLE);
        }
    }


    private void handleTitleName(float percent) {
        if (percent >= PERCENTAGE_TO_SHOW_TITLE_NAME && titleName.getVisibility() != View.VISIBLE) {
            titleName.setVisibility(View.VISIBLE);
        } else if (percent < PERCENTAGE_TO_SHOW_TITLE_NAME && titleName.getVisibility() == View.VISIBLE) {
            titleName.setVisibility(View.INVISIBLE);
        }
    }


    public void toast1(View view) {
        Snackbar.make(view, "I am Snackbar!", Snackbar.LENGTH_LONG).setAction("sure", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }).show();
    }
}
