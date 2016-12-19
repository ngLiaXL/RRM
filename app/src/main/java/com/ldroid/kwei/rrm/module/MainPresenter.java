package com.ldroid.kwei.rrm.module;


import com.ldroid.kwei.rrm.entities.in.ExpressInEntity;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;

    /**
     *
     */
    public MainPresenter(MainContract.View view) {
        this.mView = view;
    }


    @Override
    public void reqExpress(String type, String postid) {
        ExpressInEntity in = new ExpressInEntity(type,postid);
        if (!in.checkInput()) {
            mView.onError(in.getErrors().get(0));
            return;
        }

        mView.showLoading(null);





    }

}
