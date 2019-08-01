package com.example.retrofitcrud_client0.di.modules;

import com.example.retrofitcrud_client0.retrofit.BookInterface;
import com.example.retrofitcrud_client0.ui.MainActivity;
import com.example.retrofitcrud_client0.mvp.mainActivity.ContractMainActivity.IPresenterMainActivity;
import com.example.retrofitcrud_client0.mvp.mainActivity.PresenterMainActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModuleMainActivity {

    @Provides
    public static IPresenterMainActivity getPresenterMainActivity(MainActivity mainActivity, BookInterface bookInterface) {
        return new PresenterMainActivity(mainActivity, bookInterface);
    }
}
