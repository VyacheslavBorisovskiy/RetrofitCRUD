package com.example.retrofitcrud_fragments.ui.mainActivity;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.retrofitcrud_fragments.R;
import com.example.retrofitcrud_fragments.api.ApiUtils;
import com.example.retrofitcrud_fragments.api.Book;
import com.example.retrofitcrud_fragments.api.BookInterface;
import com.example.retrofitcrud_fragments.api.RecycAdapter;
import com.example.retrofitcrud_fragments.base.BaseMainFragment;

import java.util.ArrayList;

public class MainFragment extends BaseMainFragment implements ContractMainFragment.IView {

    Button btnAddBook;
    Button btnGetBookList;
    ArrayList<Book> listOfBooks = new ArrayList<>();
    Context context;
    RecyclerView recyclerView;
    RecycAdapter recycAdapter;
    //    @Inject
    ContractMainFragment.IPresenter presenter;
    private StartActivityInterface startActivityInterface;
    private GetBooksInterface getBooksInterface;
    private BookInterface bookInterface;

    //    @Inject
    public MainFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            startActivityInterface = (StartActivityInterface) context;
            getBooksInterface = (GetBooksInterface) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "must implement StartActivityInterface or GetBooksInterface");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        presenter = new PresenterMainFragment(this, ApiUtils.getBookInterface());

        bookInterface = ApiUtils.getBookInterface();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        btnAddBook = view.findViewById(R.id.btnAddBook);
        btnGetBookList = view.findViewById(R.id.btnGetBookList);


        recyclerView = view.findViewById(R.id.recyclerView);
        context = getActivity();
        recycAdapter = new RecycAdapter(context, listOfBooks);

        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(recycAdapter);
        btnGetBookList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                presenter.getBookList();
                getBooksInterface.getBooks(bookInterface);
            }
        });

        btnAddBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                presenter.onStartActivity();
                startActivityInterface.startBookActivity();
            }
        });


        return view;
    }

    @Override
    public void setData(ArrayList<Book> setBookList) {
        recycAdapter.setData(setBookList);
    }

    @Override
    public void readyToStartActivity() {
//        Intent intent = new Intent(context, BookActivity.class);
//        intent.putExtra("bookName", "");
//        context.startActivity(intent);
    }

    @Override
    public void onStop() {
        presenter.onDetachUI();
        super.onStop();
    }

    public interface StartActivityInterface {
        void startBookActivity();
    }

    public interface GetBooksInterface {
        void getBooks(BookInterface bookInterface);
    }
}
