package com.example.retrofitcrud_fragments.ui.mainActivity;

import com.example.retrofitcrud_fragments.api.Book;

import java.util.ArrayList;

public interface ContractMainFragment {

    interface IPresenter {

        void getBookList();

        void onStartActivity();

        void onDetachUI();
    }

    interface IView {
        void setData(ArrayList<Book> setBookList);

        void readyToStartActivity();
    }
}
