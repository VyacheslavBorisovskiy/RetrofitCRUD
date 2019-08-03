package com.example.retrofitcrud_fragments.di.components;

import android.app.Application;

import com.example.retrofitcrud_fragments.base.App;
import com.example.retrofitcrud_fragments.di.modules.AppModule;
import com.example.retrofitcrud_fragments.di.modules.RetrofitModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
//@Component(modules = {AndroidSupportInjectionModule.class, AppModule.class, RetrofitModule.class})
public interface AppComponent extends AndroidInjector<DaggerApplication> {

//    void inject(App app);
//
//    @Component.Builder
//    interface Builder {
//
//        @BindsInstance
//        Builder application(Application application);
//
//        AppComponent build();
//
//    }
}
