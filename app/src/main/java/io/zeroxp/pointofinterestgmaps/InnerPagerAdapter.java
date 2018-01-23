package io.zeroxp.pointofinterestgmaps;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by parthbhavsar on 2018-01-23.
 */

public class InnerPagerAdapter extends FragmentPagerAdapter {


    private final List<Fragment> innerFragmentList = new ArrayList<>();
    private final List<String> innerFragmentTitleList = new ArrayList<>();

    public InnerPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return innerFragmentTitleList.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return innerFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return innerFragmentList.size();
    }

    public void addInnerFragment(Fragment fragment, String title) {
        innerFragmentList.add(fragment);
        innerFragmentTitleList.add(title);
    }
}
