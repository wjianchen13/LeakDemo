package com.example.leakdemo.test2;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.leakdemo.R;
import com.example.leakdemo.Utils;

public class TestView2 extends RelativeLayout {

    private TextView tvTest;
    private int i = 0;
    
    public Handler mHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            tvTest.setText(msg.what + "");
            sendEmptyMessageDelayed(i ++, 1000);
            Utils.log(msg.what + "");
        }
    };
    
    public TestView2(Context context) {
        super(context);
    }

    public TestView2(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public TestView2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }
    
    private void initView(Context context) {
        inflate(context, R.layout.view_test2, this);
        tvTest = findViewById(R.id.btn_test2);
        mHandler.sendEmptyMessageDelayed(i ++, 1000);
    }
    
    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if(mHandler != null) {
            mHandler.removeCallbacksAndMessages(null);
        }
    }
}