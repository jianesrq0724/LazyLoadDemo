package com.ruiqin.lazyload.module.home;

import android.support.v4.app.Fragment;

import com.ruiqin.lazyload.module.HomePageFragment;
import com.ruiqin.lazyload.module.MyInfoFragment;
import com.ruiqin.lazyload.module.RepaymentListFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ruiqin.shen
 * 类说明：
 */

public class MainModel implements MainContract.Model {

    @Override
    public List<Fragment> initFragmentData(List<Fragment> mFragments) {
        mFragments = new ArrayList<Fragment>();
        mFragments.add(new HomePageFragment());
        mFragments.add(new RepaymentListFragment());
        mFragments.add(new MyInfoFragment());
        return mFragments;
    }
}
