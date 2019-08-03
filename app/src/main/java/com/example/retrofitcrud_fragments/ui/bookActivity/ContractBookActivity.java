package com.example.retrofitcrud_fragments.ui.bookActivity;

import com.example.retrofitcrud_fragments.api.Book;

public interface ContractBookActivity {

    interface IPresenterBookActivity {
        void addBook(Book book);

        void updateBook(final int id, final Book book);

        void deleteBook(final int id);
    }

    interface IBookView {
        void showToast(String string);
    }
}
