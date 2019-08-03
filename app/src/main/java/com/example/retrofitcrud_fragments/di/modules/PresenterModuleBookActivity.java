package com.example.retrofitcrud_fragments.di.modules;

import com.example.retrofitcrud_fragments.ui.bookActivity.BookActivity;
import com.example.retrofitcrud_fragments.ui.bookActivity.ContractBookActivity;
import com.example.retrofitcrud_fragments.ui.bookActivity.ContractBookActivity.IPresenterBookActivity;
import com.example.retrofitcrud_fragments.ui.bookActivity.PresenterBookActivity;

import dagger.Binds;
import dagger.Module;

@Module
public interface PresenterModuleBookActivity {

//    @Provides
//    IPresenterBookActivity getPresenterBookActivity(ContractBookActivity.IBookView iBookView, BookInterface bookInterface) {
//        return new PresenterBookActivity(iBookView, bookInterface);
//    }

//    @Binds
//    IPresenterBookActivity getPresenterBookActivity(PresenterBookActivity presenterBookActivity);
//
//    @Binds
//    ContractBookActivity.IBookView getIBookView(BookActivity bookActivity);
}
