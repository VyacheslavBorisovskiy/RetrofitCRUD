package com.example.retrofitcrud_client0.di.modules;

import com.example.retrofitcrud_client0.ui.mainActivity.ContractMainActivity;
import com.example.retrofitcrud_client0.ui.mainActivity.ContractMainActivity.IPresenterMainActivity;
import com.example.retrofitcrud_client0.ui.mainActivity.MainActivity;
import com.example.retrofitcrud_client0.ui.mainActivity.PresenterMainActivity;

import dagger.Binds;
import dagger.Module;

@Module
public interface PresenterModuleMainActivity {

//    @Provides
//    public static IPresenterMainActivity getPresenterMainActivity(MainActivity mainActivity, BookInterface bookInterface) {
//        return new PresenterMainActivity(mainActivity, bookInterface);
//    }

    @Binds
    IPresenterMainActivity getPresenterMainActivity(PresenterMainActivity presenterMainActivity);

    @Binds
    ContractMainActivity.IMainView getIMainView(MainActivity mainActivity);
}
