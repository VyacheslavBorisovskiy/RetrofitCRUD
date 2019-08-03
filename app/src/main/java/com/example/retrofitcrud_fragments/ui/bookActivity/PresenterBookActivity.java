package com.example.retrofitcrud_fragments.ui.bookActivity;

import com.example.retrofitcrud_fragments.api.Book;
import com.example.retrofitcrud_fragments.api.BookInterface;
import com.example.retrofitcrud_fragments.ui.bookActivity.ContractBookActivity.IBookView;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PresenterBookActivity implements ContractBookActivity.IPresenterBookActivity {

    private IBookView view;
    private BookInterface bookInterface;

        @Inject
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
        Call<ResponseBody> callBook = bookInterface.deleteBook(id);
        System.out.println(id);
        callBook.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                view.showToast(response.isSuccessful() ? "Deletion was successful! " : "Unsuccessful!");
                if (response.body() != null) {
//                    Toast.makeText(BookActivity.this, "Deletion was successful! " + id, Toast.LENGTH_SHORT).show();
                    view.showToast(response.body().toString());
                }
                else {
//                    Toast.makeText(BookActivity.this, "Unsuccessful!", Toast.LENGTH_SHORT).show();
                    view.showToast("Unsuccessful!");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                Toast.makeText(BookActivity.this, "Deletion was not executed!", Toast.LENGTH_SHORT).show();
                view.showToast("Deletion was not executed!");
            }
        });
    }
}
