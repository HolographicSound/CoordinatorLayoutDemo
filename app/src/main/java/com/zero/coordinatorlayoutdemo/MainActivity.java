package com.zero.coordinatorlayoutdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);
    }

    public void jump2UI1(View view) {
        startActivity(new Intent(this, UI_1.class));
    }

    public void jump2UI2(View view) {
        startActivity(new Intent(this, UI_2.class));
    }

    public void jump2UI3(View view) {
        startActivity(new Intent(this, UI_3.class));
    }

    public void jump2UIZX(View view) {
        startActivity(new Intent(this, UI_ZX.class));
    }

    public void jump2Scrolling(View view) {
        startActivity(new Intent(this, ScrollingActivity.class));
    }
}
