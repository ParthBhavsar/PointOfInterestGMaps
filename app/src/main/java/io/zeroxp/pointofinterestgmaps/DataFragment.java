package io.zeroxp.pointofinterestgmaps;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class DataFragment extends Fragment {

    TabLayout dataTabLayout;
    DataCustomViewPager dataViewPager;
    DataPagerAdapter dataPagerAdapter;
    public DataFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    private void setDataViewPager()
    {
        dataPagerAdapter = new DataPagerAdapter(getChildFragmentManager());
        dataPagerAdapter.addFragment(new DataAFragment(), "A");
        dataPagerAdapter.addFragment(new DataBFragment(), "B");
        dataViewPager.setAdapter(dataPagerAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_data, container, false);


        dataViewPager = (DataCustomViewPager) view.findViewById(R.id.viewPager_Data);
        dataViewPager.setOffscreenPageLimit(3);
        dataViewPager.setPagingEnabled(false);

        setDataViewPager();

        dataTabLayout = view.findViewById(R.id.tabLayout_Data);

        dataTabLayout.setupWithViewPager(dataViewPager);


        return view;
    }



}
