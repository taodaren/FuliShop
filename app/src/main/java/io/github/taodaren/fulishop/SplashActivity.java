package io.github.taodaren.fulishop;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    private static final int TIME = 3000;
    private TextView mtvTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mtvTimer = (TextView) findViewById(R.id.tv_timer);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //闪屏倒计时
        new MyCountDownTimer(TIME, 1000).start();

        //闪屏时间
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                startActivity(new Intent(SplashActivity.this, MainActivity.class));
//                finish();
//            }
//        }, TIME);
    }

    private class MyCountDownTimer extends CountDownTimer {

        /**
         * 倒计时定时器
         *
         * @param millisInFuture    倒计时时间 from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval 倒计时间隔时间
         *                          {@link #onTick(long)} callbacks.
         */
        private MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            mtvTimer.setText(getString(R.string.skip) + millisUntilFinished / 1000 + "s");
        }

        @Override
        public void onFinish() {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
        }
    }

}
