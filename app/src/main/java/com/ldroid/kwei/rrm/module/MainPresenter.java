package com.ldroid.kwei.rrm.module;


import com.ldroid.kwei.rrm.common.entities.OutputListEntity;
import com.ldroid.kwei.rrm.common.network.ExpressRetrofit;
import com.ldroid.kwei.rrm.entities.in.ExpressInEntity;
import com.ldroid.kwei.rrm.entities.out.ExpressOutEntity;

import rx.Subscriber;
import rx.Subscription;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;
    private Subscription mSubscription;

    /**
     *
     */
    public MainPresenter(MainContract.View view) {
        this.mView = view;
    }


    @Override
    public void reqExpress(String type, String postid) {
        ExpressInEntity in = new ExpressInEntity(type, postid);
        if (!in.checkInput()) {
            mView.onError(in.getErrors().get(0));
            return;
        }

        mView.showLoading(null);

        if (mSubscription != null) {
            mSubscription.unsubscribe();
        }
        mSubscription = ExpressRetrofit.get()
                .reqExpress("shentong", "123123")
                .subscribe(new Subscriber<OutputListEntity<ExpressOutEntity>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.onError(e.toString());
                    }

                    @Override
                    public void onNext(OutputListEntity<ExpressOutEntity> response) {
                        mView.onRespExpress(response.data);
                    }
                });


    }

}
