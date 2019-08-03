package com.example.retrofitcrud_fragments.ui.mainActivity;

public interface ContractMainActivity {

    interface IView extends ContractMainFragment.IView.GetBooksInterface, ContractMainFragment.IView.StartActivityInterface{
        void setFragment(MainFragment mainFragment);
    }

    interface IPresenter {

    }
}
