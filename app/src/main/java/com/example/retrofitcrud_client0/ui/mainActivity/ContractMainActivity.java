package com.example.retrofitcrud_client0.ui.mainActivity;

import android.content.Context;
import android.content.Intent;

import com.example.retrofitcrud_client0.api.Book;

import java.util.ArrayList;

public interface ContractMainActivity {

    interface IPresenterMainActivity {
        void getBookList();

        void onStartActivity(Context context);
    }

    interface IMainView {
        void setData(ArrayList<Book> setBookList);

        void readyToStartActivity(Intent intent);
    }
}
