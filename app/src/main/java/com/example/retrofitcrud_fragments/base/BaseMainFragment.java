package com.example.retrofitcrud_fragments.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import dagger.android.support.AndroidSupportInjection;

public class BaseMainFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
//        AndroidSupportInjection.inject(this);
        super.onCreate(savedInstanceState);
    }


}
