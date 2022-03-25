package com.example.leakdemo.test1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.leakdemo.R;

import leakcanary.LeakCanary;

public class TestActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);

        Singleton singleton = Singleton.newInstance(this);
        
    }
}