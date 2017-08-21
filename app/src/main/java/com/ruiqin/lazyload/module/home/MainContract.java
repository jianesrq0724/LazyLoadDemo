package com.ruiqin.lazyload.module.home;

import android.support.v4.app.Fragment;

import com.ruiqin.lazyload.base.BaseModel;
import com.ruiqin.lazyload.base.BasePresenter;
import com.ruiqin.lazyload.base.BaseView;

import java.util.List;

/**
 * Created by ruiqin.shen
 * 类说明：
 */

public interface MainContract {
    interface Model extends BaseModel {
        List<Fragment> initFragmentData(List<Fragment> fragments);
    }

    interface View extends BaseView {
        void initFragmentDataSuccess(List<Fragment> fragments);
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        abstract void initFragmentData(List<Fragment> fragments);
    }
}
