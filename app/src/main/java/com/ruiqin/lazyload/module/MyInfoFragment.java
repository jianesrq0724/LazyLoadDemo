package com.ruiqin.lazyload.module;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ruiqin.lazyload.R;
import com.ruiqin.lazyload.base.BaseFragment;

public class MyInfoFragment extends BaseFragment {

    @Override
    protected void lazyLoad() {

    }

    @Override
    protected void stopLoad() {

    }


    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_activity_my_info;
    }
}
