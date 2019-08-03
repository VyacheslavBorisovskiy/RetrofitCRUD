package com.example.retrofitcrud_fragments.ui.mainActivity;

import com.example.retrofitcrud_fragments.api.Book;
import com.example.retrofitcrud_fragments.api.BookInterface;

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

        interface GetBooksInterface {
            void getBooks(BookInterface bookInterface);
        }

        interface StartActivityInterface {
            void startBookActivity();
        }
    }
}
