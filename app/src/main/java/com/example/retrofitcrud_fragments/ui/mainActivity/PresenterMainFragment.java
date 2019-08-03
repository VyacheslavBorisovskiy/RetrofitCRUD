package com.example.retrofitcrud_fragments.ui.mainActivity;

import com.example.retrofitcrud_fragments.api.Book;
import com.example.retrofitcrud_fragments.api.BookInterface;
import com.example.retrofitcrud_fragments.ui.mainActivity.ContractMainFragment.IView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PresenterMainFragment implements ContractMainFragment.IPresenter {

    private IView view;
    private BookInterface bookInterface;


    //    @Inject
    public PresenterMainFragment(ContractMainFragment.IView view, BookInterface bookInterface) {
        this.view = view;
        this.bookInterface = bookInterface;
    }

    @Override
    public void getBookList() {
        Call<ArrayList<Book>> call = bookInterface.getBooks();
        call.enqueue(new Callback<ArrayList<Book>>() {
            @Override
            public void onResponse(Call<ArrayList<Book>> call, Response<ArrayList<Book>> response) {
                if (view != null) {
                    if (response.isSuccessful()) {

                        view.setData(response.body());
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! getBookList()");

                    }
//                    view.setData(arrayList);
                    //listOfBooks.clear();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Book>> call, Throwable t) {
            }
        });
    }

    @Override
    public void onStartActivity() {
        view.readyToStartActivity();
    }

    @Override
    public void onDetachUI() {
        view = null;
    }


}
