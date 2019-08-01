package com.example.retrofitcrud_client0.mvp.mainActivity;

import android.content.Context;
import android.content.Intent;

import com.example.retrofitcrud_client0.Book;
import com.example.retrofitcrud_client0.BookActivity;
import com.example.retrofitcrud_client0.BookInterface;
import com.example.retrofitcrud_client0.mvp.mainActivity.ContractMainActivity.IView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PresenterMainActivity implements ContractMainActivity.IPresenter {

    private IView view;
    private BookInterface bookInterface;

    public PresenterMainActivity(IView view, BookInterface bookInterface) {
        this.view = view;
        this.bookInterface = bookInterface;
    }

    @Override
    public void getBookList(){
        Call<ArrayList<Book>> call = bookInterface.getBooks();
        call.enqueue(new Callback<ArrayList<Book>>(){
            @Override
            public void onResponse(Call<ArrayList<Book>> call, Response<ArrayList<Book>> response) {
//                if(response.isSuccessful()){
                    view.setData(response.body());
//                }
//                view.setData(listOfBooks);
                //listOfBooks.clear();
            }

            @Override
            public void onFailure(Call<ArrayList<Book>> call, Throwable t) {
            }
        });
    }

    @Override
    public void onStartActivity(Context context) {
        Intent intent = new Intent(context, BookActivity.class);
        intent.putExtra("bookName", "");
        view.startActivity(intent);
    }
}
