package com.yuanbaopu.fideapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class TabMain extends FragmentActivity implements OnClickListener{
    //声明ViewPager
    private ViewPager mViewPager;
    //适配器
    private FragmentPagerAdapter mAdapter;
    //装载Fragment的集合
    private List<Fragment> mFragments;

    //四个Tab对应的布局
    private LinearLayout mTabHome;
    private LinearLayout mTabMyLoan;
    private LinearLayout mTabMyData;
    private LinearLayout mTabMy;

    //四个Tab对应的ImageButton
    private ImageButton mImgHome;
    private ImageButton mImgMyLoan;
    private ImageButton mImgMyData;
    private ImageButton mImgMy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_main);
        initViews();//初始化控件
        initEvents();//初始化事件
//        selectTab(0);//默认选中第一个Tab
        initDatas();
    }

    //初始化控件
    private void initViews() {
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);

        mTabHome = (LinearLayout) findViewById(R.id.id_tab_weixin);
        mTabMyLoan = (LinearLayout) findViewById(R.id.id_tab_frd);
        mTabMyData = (LinearLayout) findViewById(R.id.id_tab_address);
        mTabMy = (LinearLayout) findViewById(R.id.id_tab_setting);

        mImgHome = (ImageButton) findViewById(R.id.id_tab_weixin_img);
        mImgMyLoan = (ImageButton) findViewById(R.id.id_tab_frd_img);
        mImgMyData = (ImageButton) findViewById(R.id.id_tab_address_img);
        mImgMy = (ImageButton) findViewById(R.id.id_tab_setting_img);

    }

    private void initEvents() {
        //设置四个Tab的点击事件
        mTabHome.setOnClickListener(this);
        mTabMyLoan.setOnClickListener(this);
        mTabMyData.setOnClickListener(this);
        mTabMy.setOnClickListener(this);
    }

    private void initDatas() {
        mFragments = new ArrayList<>();
        //将四个Fragment加入集合中
        mFragments.add(new MyHomeFragment());
        mFragments.add(new MyLoanFragment());
        mFragments.add(new MyDataFragment());
        mFragments.add(new MyFragment());

        //初始化适配器
        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {//从集合中获取对应位置的Fragment
                return mFragments.get(position);
            }

            @Override
            public int getCount() {//获取集合中Fragment的总数
                return mFragments.size();
            }

        };
        //不要忘记设置ViewPager的适配器
        mViewPager.setAdapter(mAdapter);
        //设置ViewPager的切换监听
        mViewPager.addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            //页面滚动事件
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            //页面选中事件
            @Override
            public void onPageSelected(int position) {
                //设置position对应的集合中的Fragment
                mViewPager.setCurrentItem(position);
                resetImgs();
                selectTab(position);
            }

            @Override
            //页面滚动状态改变事件
            public void onPageScrollStateChanged(int state) {

            }
        });
    }



    @Override
    public void onClick(View v) {
        //先将四个ImageButton置为灰色
        resetImgs();

        //根据点击的Tab切换不同的页面及设置对应的ImageButton为绿色
        switch (v.getId()) {
            case R.id.id_tab_weixin:
                selectTab(0);
                break;
            case R.id.id_tab_frd:
                selectTab(1);
                break;
            case R.id.id_tab_address:
                selectTab(2);
                break;
            case R.id.id_tab_setting:
                selectTab(3);
                break;
        }
    }


    private void selectTab(int i) {
        //获取title
        TextView tv = (TextView) findViewById(R.id.id_top_title);
        //获取title array
        String[] titles =getResources().getStringArray(R.array.tab_title);
        //设置title
        tv.setText(titles[i]);

        //根据点击的Tab设置对应的ImageButton为绿色
        switch (i) {
            case 0:
                mImgHome.setImageResource(R.mipmap.tab_weixin_pressed);
                break;
            case 1:
                mImgMyLoan.setImageResource(R.mipmap.tab_find_frd_pressed);
                break;
            case 2:
                mImgMyData.setImageResource(R.mipmap.tab_address_pressed);
                break;
            case 3:
                mImgMy.setImageResource(R.mipmap.tab_settings_pressed);
                break;
        }
        //设置当前点击的Tab所对应的页面
        mViewPager.setCurrentItem(i);
    }


    //将四个ImageButton设置为灰色
    private void resetImgs() {
        mImgHome.setImageResource(R.mipmap.tab_weixin_normal);
        mImgMyLoan.setImageResource(R.mipmap.tab_find_frd_normal);
        mImgMyData.setImageResource(R.mipmap.tab_address_normal);
        mImgMy.setImageResource(R.mipmap.tab_settings_normal);
    }
}
