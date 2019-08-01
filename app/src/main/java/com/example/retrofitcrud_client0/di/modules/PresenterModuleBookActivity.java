package com.example.retrofitcrud_client0.di.modules;

import com.example.retrofitcrud_client0.ui.bookActivity.BookActivity;
import com.example.retrofitcrud_client0.ui.bookActivity.ContractBookActivity;
import com.example.retrofitcrud_client0.ui.bookActivity.ContractBookActivity.IPresenterBookActivity;
import com.example.retrofitcrud_client0.ui.bookActivity.PresenterBookActivity;

import dagger.Binds;
import dagger.Module;

@Module
public interface PresenterModuleBookActivity {

//    @Provides
//    IPresenterBookActivity getPresenterBookActivity(ContractBookActivity.IBookView iBookView, BookInterface bookInterface) {
//        return new PresenterBookActivity(iBookView, bookInterface);
//    }

    @Binds
    IPresenterBookActivity getPresenterBookActivity(PresenterBookActivity presenterBookActivity);

    @Binds
    ContractBookActivity.IBookView getIBookView(BookActivity bookActivity);
}
