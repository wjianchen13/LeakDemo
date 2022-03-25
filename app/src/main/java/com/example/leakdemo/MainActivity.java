package com.example.leakdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.leakdemo.test1.TestActivity1;
import com.example.leakdemo.test2.TestActivity2;

import leakcanary.LeakCanary;
import leakcanary.ObjectWatcher;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new ObjectWatcher(this).expectWeaklyReachable();
    }
    
    public void onTest1(View v) {
        startActivity(new Intent(this, TestActivity1.class));
    }
    
    public void onTest2(View v) {
        startActivity(new Intent(this, TestActivity2.class));
    }
    
}