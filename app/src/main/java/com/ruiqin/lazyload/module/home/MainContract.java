package com.ruiqin.lazyload.module.home;

import com.ruiqin.lazyload.base.BaseModel;
import com.ruiqin.lazyload.base.BasePresenter;
import com.ruiqin.lazyload.base.BaseView;
import com.ruiqin.lazyload.module.home.adapter.MainRecyclerAdapter;
import com.ruiqin.lazyload.module.home.bean.MainRecyclerData;

import java.util.List;

/**
 * Created by ruiqin.shen
 * 类说明：
 */

public interface MainContract {
    interface Model extends BaseModel {
        List<MainRecyclerData> initData();
    }

    interface View extends BaseView {
        void setRecyclerAdapterSuccess(MainRecyclerAdapter mainRecyclerAdapter);
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        abstract void setAdapter();
    }
}
