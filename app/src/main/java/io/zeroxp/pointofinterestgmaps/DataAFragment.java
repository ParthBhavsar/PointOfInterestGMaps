package io.zeroxp.pointofinterestgmaps;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DataAFragment extends Fragment {


    private ViewPager innerViewPager;
    private TabLayout innerTabLayout;
    private InnerPagerAdapter innerPagerAdapter;

    public DataAFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_data_a, container, false);

        innerViewPager = (ViewPager) view.findViewById(R.id.viewPager_inner);
        //saves 6 pages in memory
        innerViewPager.setOffscreenPageLimit(6);

        setDataViewPager();

        innerTabLayout = (TabLayout) view.findViewById(R.id.tabLayout_inner);

        innerTabLayout.setupWithViewPager(innerViewPager);


        return view;
    }

    private void setDataViewPager() {
        innerPagerAdapter = new InnerPagerAdapter(getChildFragmentManager());

        //Create 7 pages
        for (int fragNum = 1; fragNum < 7; fragNum++) {
            InnerFragment innerFragment = new InnerFragment();
            innerFragment.setPageNumber(fragNum);
            innerPagerAdapter.addInnerFragment(innerFragment, fragNum+"");

        }

        Log.e("DataAFragment", "setDataViewPager");
        innerViewPager.setAdapter(innerPagerAdapter);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        setRetainInstance(true);
    }



}
