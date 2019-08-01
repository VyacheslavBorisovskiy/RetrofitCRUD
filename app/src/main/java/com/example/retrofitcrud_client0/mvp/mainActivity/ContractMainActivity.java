package com.example.retrofitcrud_client0.mvp.mainActivity;

import android.content.Context;
import android.content.Intent;

import com.example.retrofitcrud_client0.Book;

import java.util.ArrayList;

public interface ContractMainActivity {

    interface IPresenter {
        void getBookList();

        void onStartActivity(Context context);
    }

    interface IView {
        void setData(ArrayList<Book> setBookList);

        void startActivity(Intent intent);
    }
}
