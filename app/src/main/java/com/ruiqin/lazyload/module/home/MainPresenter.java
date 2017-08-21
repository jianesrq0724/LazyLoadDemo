package com.ruiqin.lazyload.module.home;

import android.support.v4.app.Fragment;

import java.util.List;

/**
 * Created by ruiqin.shen
 * 类说明：
 */

public class MainPresenter extends MainContract.Presenter {

    @Override
    void initFragmentData(List<Fragment> mFragments) {
        mView.initFragmentDataSuccess(mModel.initFragmentData(mFragments));
    }
}
