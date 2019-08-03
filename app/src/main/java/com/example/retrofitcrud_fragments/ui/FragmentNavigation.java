package com.example.retrofitcrud_fragments.ui;

import com.example.retrofitcrud_fragments.ui.mainActivity.MainFragment;

public interface FragmentNavigation {
    interface IView {
        void attachPresenter(IPresenterNavigation IPresenterNavigation);
    }

    interface IPresenterNavigation {
        void addFragment(MainFragment mainFragment);
    }
}
