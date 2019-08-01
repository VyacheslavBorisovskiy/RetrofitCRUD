package com.example.retrofitcrud_client0.ui.mainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.retrofitcrud_client0.R;
import com.example.retrofitcrud_client0.api.Book;
import com.example.retrofitcrud_client0.api.BookInterface;
import com.example.retrofitcrud_client0.api.RecycAdapter;
import com.example.retrofitcrud_client0.ui.mainActivity.ContractMainActivity.IPresenterMainActivity;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity implements ContractMainActivity.IMainView {
    Button btnAddBook;
    Button btnGetBookList;
    BookInterface bookInterface;
    ArrayList<Book> listOfBooks = new ArrayList<>();
    RecyclerView recyclerView;
    RecycAdapter recycAdapter;
    @Inject
    IPresenterMainActivity presenter;
//    PresenterMainActivity presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        bookInterface = ApiUtils.getBookInterface();
//        presenter = new PresenterMainActivity(this, bookInterface);

        btnAddBook = findViewById(R.id.btnAddBook);
        btnGetBookList = findViewById(R.id.btnGetBookList);
        btnGetBookList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.getBookList();
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        recycAdapter = new RecycAdapter(this, listOfBooks);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recycAdapter);

        btnAddBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onStartActivity(MainActivity.this);

//                Intent intent = new Intent(MainActivity.this, BookActivity.class);
//                intent.putExtra("bookName", "");
//                readyToStartActivity(intent);
            }
        });
    }

    @Override
    public void setData(ArrayList<Book> setBookList) {
        recycAdapter.setData(setBookList);
    }

    @Override
    public void readyToStartActivity(Intent intent) {
        startActivity(intent);
    }

    //    public void getBookList(){
//        Call<ArrayList<Book>> call = bookInterface.getBooks();
//        call.enqueue(new Callback<ArrayList<Book>>(){
//            @Override
//            public void onResponse(Call<ArrayList<Book>> call, Response<ArrayList<Book>> response) {
//                if(response.isSuccessful()){
//                    listOfBooks = response.body();
//                }
//            recycAdapter.setData(listOfBooks);
//                //listOfBooks.clear();
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<Book>> call, Throwable t) {
//            }
//        });
//    }


}
