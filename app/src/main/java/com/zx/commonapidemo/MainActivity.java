package com.zx.commonapidemo;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ObjectAnimator animator = TestAnimate.tada(findViewById(R.id.test_animate));
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.start();
    }
}
