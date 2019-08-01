package com.example.retrofitcrud_client0.di.modules;

import com.example.retrofitcrud_client0.ui.bookActivity.BookActivity;
import com.example.retrofitcrud_client0.ui.mainActivity.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface AppModule {

    @ContributesAndroidInjector(modules = {PresenterModuleMainActivity.class})
    MainActivity contributeMainActivityInjector();

    @ContributesAndroidInjector(modules = {PresenterModuleBookActivity.class})
    BookActivity contributeBookActivityInjector();
}
