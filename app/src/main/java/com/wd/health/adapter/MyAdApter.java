package com.wd.health.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MyAdApter extends FragmentPagerAdapter {
    public ArrayList<Fragment> flist=new ArrayList<>();

    public MyAdApter(FragmentManager fm, ArrayList<Fragment> flist) {
        super(fm);
        this.flist.addAll(flist);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = flist.get(i);
        return fragment;
    }

    @Override
    public int getCount() {
        return flist.size();
    }
}
