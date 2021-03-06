package io.zeroxp.pointofinterestgmaps;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by parthbhavsar on 2018-01-22.
 */

public class DataPagerAdapter extends FragmentPagerAdapter {


    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> fragmentTitleList = new ArrayList<>();

    public DataPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitleList.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    public void addFragment(Fragment fragment, String title) {
        fragmentList.add(fragment);
        fragmentTitleList.add(title);
    }
}
