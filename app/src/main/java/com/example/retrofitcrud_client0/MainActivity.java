package com.example.retrofitcrud_client0;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.retrofitcrud_client0.mvp.mainActivity.ContractMainActivity;
import com.example.retrofitcrud_client0.mvp.mainActivity.PresenterMainActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ContractMainActivity.IView {
    Button btnAddBook;
    Button btnGetBookList;
    BookInterface bookInterface;
    ArrayList<Book> listOfBooks = new ArrayList<>();
    RecyclerView recyclerView;
    RecycAdapter recycAdapter;
    PresenterMainActivity presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bookInterface = ApiUtils.getBookInterface();
        presenter = new PresenterMainActivity(this, bookInterface);

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
//                startActivity(intent);
            }
        });
    }

    @Override
    public void setData(ArrayList<Book> setBookList) {
        recycAdapter.setData(setBookList);
    }

    @Override
    public void startActivity(Intent intent) {
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
