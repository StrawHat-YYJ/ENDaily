package com.yyj.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by 草帽儿 on 2016/1/23.
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter{
     ArrayList<Fragment> viewContainer;
     ArrayList<String> titleContainer;

    public MyFragmentPagerAdapter(FragmentManager fm,ArrayList<Fragment> viewContainer,
                                  ArrayList<String> titleContainer) {
        super(fm);
        this.viewContainer=viewContainer;
        this.titleContainer=titleContainer;

    }

    @Override
    public Fragment getItem(int position) {
        return viewContainer.get(position);
    }

    @Override
    public int getCount() {
        return viewContainer!=null?viewContainer.size():0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleContainer.get(position);
    }
}
