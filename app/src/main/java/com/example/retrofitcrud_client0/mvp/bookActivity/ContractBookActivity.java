package com.example.retrofitcrud_client0.mvp.bookActivity;

import com.example.retrofitcrud_client0.retrofit.Book;

public interface ContractBookActivity {

    interface IPresenter {
        void addBook(Book book);

        void updateBook(final int id, final Book book);

        void deleteBook(final int id);
    }

    interface IBookView {
        void showToast(String string);
    }
}
