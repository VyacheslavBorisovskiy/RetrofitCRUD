package com.example.retrofitcrud_fragments.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class BaseMainActivity extends AppCompatActivity {//implements HasSupportFragmentInjector {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
    }
//    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;
//    @Override
//    public AndroidInjector<Fragment> supportFragmentInjector() {
//        return dispatchingAndroidInjector;
//    }
}
