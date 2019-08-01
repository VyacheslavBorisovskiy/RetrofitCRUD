package com.example.retrofitcrud_client0.di.modules;

import com.example.retrofitcrud_client0.ui.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface AppModule {

    @ContributesAndroidInjector(modules = {PresenterModuleMainActivity.class})
    MainActivity contributeMainActivityInjector();
}
