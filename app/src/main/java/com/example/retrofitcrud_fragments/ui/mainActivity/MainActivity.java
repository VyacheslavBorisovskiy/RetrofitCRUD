package com.example.retrofitcrud_fragments.ui.mainActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.retrofitcrud_fragments.R;
import com.example.retrofitcrud_fragments.api.Book;
import com.example.retrofitcrud_fragments.api.BookInterface;
import com.example.retrofitcrud_fragments.base.BaseMainActivity;
import com.example.retrofitcrud_fragments.ui.bookActivity.BookActivity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseMainActivity implements ContractMainActivity.IView {// implements MainFragment.StartActivityInterface, MainFragment.GetBooksInterface {

    //    @Inject
    MainFragment mainFragment;
    private ContractMainActivity.IPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainFragment = new MainFragment();

        presenter = new PresenterMainActivity()


    }

    @Override
    public void startBookActivity() {
        Intent intent = new Intent(this, BookActivity.class);
        intent.putExtra("bookName", "");
        startActivity(intent);
    }

    @Override
    public void getBooks(BookInterface bookInterface) {
        Call<ArrayList<Book>> call = bookInterface.getBooks();
        call.enqueue(new Callback<ArrayList<Book>>() {
            @Override
            public void onResponse(Call<ArrayList<Book>> call, Response<ArrayList<Book>> response) {
//                if(response.isSuccessful()){
//                if (view != null) {
                mainFragment.setData(response.body());
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! getBookList()");
//                }
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
    public void setFragment(MainFragment mainFragment) {
        mainFragment.attachPresenter(presenter);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, mainFragment)
                .addToBackStack(null)
                .commit();
    }
}
