package com.ruiqin.lazyload.module.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;

import com.ruiqin.lazyload.R;
import com.ruiqin.lazyload.base.BaseActivity;
import com.ruiqin.lazyload.module.home.adapter.MainAdapter;
import com.ruiqin.lazyload.util.ToastUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


public class MainActivity extends BaseActivity<MainPresenter, MainModel> implements MainContract.View {
    public List<Fragment> mFragments;
    @BindView(R.id.main_viewpager)
    ViewPager mainViewpager;
    @BindView(R.id.rdoBtn_main_pager)
    RadioButton mRdoBtnMainPager;
    @BindView(R.id.rdoBtn_repayment)
    RadioButton mRdoBtnRepayment;
    @BindView(R.id.rdoBtn_myinfo)
    RadioButton mRdoBtnMyinfo;

    @Override
    protected int getFragmentContentId() {
        return 0;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter.initFragmentData(mFragments);
        setAdapter();
    }

    @Override
    public boolean canBack() {
        mToolbarTitle.setText("Lazy-Load");
        return false;
    }

    /**
     * 设置适配器
     */
    private void setAdapter() {
        MainAdapter mainAdapter = new MainAdapter(getSupportFragmentManager(), mFragments);
        mainViewpager.setAdapter(mainAdapter);
        mainViewpager.setOffscreenPageLimit(2);
        PageChangeListener();
    }

    private long lastClickTime;

    /**
     * 返回键 监听
     */
    @Override
    public void onBackPressed() {
        long currentClickTime = System.currentTimeMillis();
        if (currentClickTime - lastClickTime > 2000) {
            ToastUtils.showShort("再按一次退出");
            lastClickTime = currentClickTime;
        } else {
            super.onBackPressed();
        }
    }

    /**
     * ViewPager改变监听
     */
    private void PageChangeListener() {
        mainViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                radioButtonClickLocation = position;
                setRecoveryPreviousColor();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public int radioButtonClickLocation = 0;

    /**
     * 导航栏的点击事件
     *
     * @param view
     */
    @OnClick({R.id.rdoBtn_main_pager, R.id.rdoBtn_repayment, R.id.rdoBtn_myinfo})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rdoBtn_main_pager:
                radioButtonClickLocation = 0;
                mainViewpager.setCurrentItem(0, false);
                break;
            case R.id.rdoBtn_repayment:
                radioButtonClickLocation = 1;
                mainViewpager.setCurrentItem(1, false);
                break;
            case R.id.rdoBtn_myinfo:
                radioButtonClickLocation = 2;
                mainViewpager.setCurrentItem(2, false);
                break;
            default:
                break;
        }
    }

    /**
     * 改变导航栏的颜色
     */
    private void setRecoveryPreviousColor() {
        switch (radioButtonClickLocation) {
            case 0:
                mRdoBtnMainPager.setChecked(true);
                break;
            case 1:
                mRdoBtnRepayment.setChecked(true);
                break;
            case 2:
                mRdoBtnMyinfo.setChecked(true);
                break;
            default:
                break;
        }
    }

    @Override
    public void initFragmentDataSuccess(List<Fragment> fragments) {
        this.mFragments = fragments;
    }
}
