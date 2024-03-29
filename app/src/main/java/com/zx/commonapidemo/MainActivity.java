package com.zx.commonapidemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.zx.commonim.CommonIMManager;
import com.zx.commonim.api.IMessage;
import com.zx.commonim.message.TextMessage;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final View view = findViewById(R.id.test_animate);
//        ObjectAnimator animator = TestAnimate.tada(view);
//        animator.setRepeatCount(ValueAnimator.INFINITE);
//        animator.start();
        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale_animate);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.startAnimation(animation);
            }
        });


        IMessage<String> iMessage = TextMessage.creatTextMessage("测试", "abcd");
        CommonIMManager.getInstance(this).sendMessage(iMessage);

    }
}
