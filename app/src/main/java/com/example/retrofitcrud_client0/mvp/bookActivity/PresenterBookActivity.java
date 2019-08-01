package com.example.retrofitcrud_client0.mvp.bookActivity;

import com.example.retrofitcrud_client0.Book;
import com.example.retrofitcrud_client0.BookInterface;
import com.example.retrofitcrud_client0.mvp.bookActivity.ContractBookActivity.IBookView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PresenterBookActivity implements ContractBookActivity.IPresenter {

    private IBookView view;
    private BookInterface bookInterface;

    public PresenterBookActivity(IBookView view, BookInterface bookInterface) {
        this.view = view;
        this.bookInterface = bookInterface;
    }

    @Override
    public void addBook(Book book) {
        Call<Book> callBook = bookInterface.addBook(book);

        callBook.enqueue(new Callback<Book>() {
            @Override
            public void onResponse(Call<Book> call, Response<Book> response) {
                if (response.isSuccessful()) {
//                    Toast.makeText(BookActivity.this, "Book created successfully!", Toast.LENGTH_SHORT).show();
                    view.showToast("Book created successfully!");
                }
            }

            @Override
            public void onFailure(Call<Book> call, Throwable t) {
//                Toast.makeText(BookActivity.this, "Book has not save!", Toast.LENGTH_SHORT).show();
                view.showToast("Book has not save!");
            }
        });
    }

    @Override
    public void updateBook(final int id, final Book book) {
        Call<Book> callBook = bookInterface.updateBook(id, book);
        callBook.enqueue(new Callback<Book>() {
            @Override
            public void onResponse(Call<Book> call, Response<Book> response) {
                if (response.isSuccessful()) {
//                    Toast.makeText(BookActivity.this, "Book updated successful! " + book.getId(), Toast.LENGTH_SHORT).show();
                    view.showToast("Book updated successful! " + book.getId());
                }
            }

            @Override
            public void onFailure(Call<Book> call, Throwable t) {
//                Toast.makeText(BookActivity.this, "Book update was unsuccesful!", Toast.LENGTH_SHORT).show();
                view.showToast("Book update was unsuccesful!");
            }
        });
    }

    @Override
    public void deleteBook(final int id) {
        Call<Book> callBook = bookInterface.deleteBook(id);
        System.out.println(id);
        callBook.enqueue(new Callback<Book>() {
            @Override
            public void onResponse(Call<Book> call, Response<Book> response) {
//                view.showToast(response.isSuccessful() ? "Deletion was successful! " : "Unsuccessful!");
                if (response.isSuccessful()) {
//                    Toast.makeText(BookActivity.this, "Deletion was successful! " + id, Toast.LENGTH_SHORT).show();
                    view.showToast("Deletion was successful! ");
                }
//                else {
////                    Toast.makeText(BookActivity.this, "Unsuccessful!", Toast.LENGTH_SHORT).show();
//                    view.showToast("Unsuccessful!");
//                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
//                Toast.makeText(BookActivity.this, "Deletion was not executed!", Toast.LENGTH_SHORT).show();
                view.showToast("Deletion was not executed!");
            }
        });
    }
}
