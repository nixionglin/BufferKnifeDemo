package com.example.jh.butterknife;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * 作者：jinhui on 2017/3/16
 * 邮箱：1004260403@qq.com
 */

public class SecondActivity extends AppCompatActivity {

    FragmentA fragmentA;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        fragmentA = new FragmentA();
        FragmentManager fm = this.getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.ll, fragmentA);
        transaction.commit();
    }
}
