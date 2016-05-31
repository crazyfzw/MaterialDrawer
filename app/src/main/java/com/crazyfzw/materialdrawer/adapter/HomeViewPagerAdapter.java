package com.crazyfzw.materialdrawer.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Crazyfzw on 2016/4/8.
 */
public class HomeViewPagerAdapter extends FragmentStatePagerAdapter {


    private final List<Fragment> myFragments = new ArrayList<>();
    private final List<String> myFragmentTitles = new ArrayList<>();
    private Context context;

    public HomeViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    public void addFragment(Fragment fragment, String title) {
        myFragments.add(fragment);
        myFragmentTitles.add(title);
    }

    @Override
    public Fragment getItem(int position) {
        return myFragments.get(position);
    }

    @Override
    public int getCount() {
        return myFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return myFragmentTitles.get(position);
    }
}