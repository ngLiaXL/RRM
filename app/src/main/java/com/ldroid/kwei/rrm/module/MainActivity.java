package com.ldroid.kwei.rrm.module;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.ldroid.kwei.rrm.R;
import com.ldroid.kwei.rrm.entities.out.ExpressOutEntity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private MainContract.Presenter mPresenter;

    private TextView mTvZone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvZone = (TextView) findViewById(R.id.zone);
        mPresenter = new MainPresenter(this);
    }


    public void reqExpress(View view) {
        mPresenter.reqExpress("shentong", "123123");
    }

    @Override
    public void onRespExpress(ArrayList<ExpressOutEntity> response) {

        StringBuffer sbf = new StringBuffer();
        for (ExpressOutEntity kd : response) {
            sbf.append(kd.toString()).append("\r\n\n\n");
        }


        mTvZone.setText(sbf.toString());
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showLoading(String msg) {
        mTvZone.setText("加载中...");
    }

    @Override
    public void dismissLoading() {
        mTvZone.setText("加载完成...");

    }

    @Override
    public void onError(String msg) {
        mTvZone.setText("接口请求失败：" + msg);
    }

}
