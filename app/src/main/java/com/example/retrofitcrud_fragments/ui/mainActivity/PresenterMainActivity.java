package com.example.retrofitcrud_fragments.ui.mainActivity;

import com.example.retrofitcrud_fragments.ui.FragmentNavigation;

public class PresenterMainActivity implements ContractMainActivity.IPresenter, FragmentNavigation.IPresenterNavigation {

    private ContractMainActivity.IView view;

    @Override
    public void addFragment(MainFragment mainFragment) {
        view.setFragment(mainFragment);
    }
}
