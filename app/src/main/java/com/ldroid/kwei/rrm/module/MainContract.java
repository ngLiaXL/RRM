package com.ldroid.kwei.rrm.module;


import com.ldroid.kwei.rrm.common.mvp.BasePresenter;
import com.ldroid.kwei.rrm.common.mvp.BaseView;
import com.ldroid.kwei.rrm.entities.out.ExpressOutEntity;

import java.util.ArrayList;

public interface MainContract {

	interface View extends BaseView {
		void onRespExpress(ArrayList<ExpressOutEntity> response);
	}

	interface Presenter extends BasePresenter {
		void reqExpress(String type, String postid);
	}
}
