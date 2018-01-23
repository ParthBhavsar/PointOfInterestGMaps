package io.zeroxp.pointofinterestgmaps;


import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;


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


    private void changeTabColor(boolean changeTabColor)
    {
        LinearLayout tabsContainer = (LinearLayout) dataTabLayout.getChildAt(0);

        if(changeTabColor)
        {
            Log.e("ChangeTabColor", "StartAnimation");
            animateTabColor(tabsContainer.getChildAt(0), Color.parseColor("#FFFFFF") ,Color.parseColor("#EF9A9A"));
            animateTabColor(tabsContainer.getChildAt(1), Color.parseColor("#FFFFFF") ,Color.parseColor("#FFECB3"));

        }

        else
        {

            Log.e("ChangeTabColor", "StopAnimation");
//            tabsContainer.getChildAt(0).setBackgroundColor(Color.parseColor("#FFFFFF"));
//            tabsContainer.getChildAt(1).setBackgroundColor(Color.parseColor("#FFFFFF"));
            stopAnimatingTabColor(tabsContainer.getChildAt(0), Color.parseColor("#FFFFFF"), Color.parseColor("#FFFFFF"));
            stopAnimatingTabColor(tabsContainer.getChildAt(1), Color.parseColor("#FFFFFF"), Color.parseColor("#FFFFFF"));

        }
    }


    private void animateTabColor(View tabsContainer, int colorStart, int colorEnd)
    {
        ValueAnimator valueAnimator = ObjectAnimator.ofInt(tabsContainer, "backgroundColor", colorStart, colorEnd);

        valueAnimator.setDuration(500);
        valueAnimator.setEvaluator(new ArgbEvaluator());
        valueAnimator.setRepeatCount(1);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE); //repeats the animation infinitely
        valueAnimator.start();
    }

    private void stopAnimatingTabColor(View tabsContainer, int colorStart, int colorEnd)
    {
        ValueAnimator valueAnimator = ObjectAnimator.ofInt(tabsContainer, "backgroundColor", colorStart, colorEnd);

        valueAnimator.setDuration(500);
        valueAnimator.setEvaluator(new ArgbEvaluator());
        valueAnimator.setRepeatCount(0);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE); //repeats the animation infinitely
        valueAnimator.start();
    }


    public class ChangeTabColorBroadcastReceiver extends BroadcastReceiver {
        private static final String TAG = "MyBroadcastReceiver";
        @Override
        public void onReceive(Context context, Intent intent) {
            boolean changeTabColor = intent.getExtras().getBoolean("changeTabColor");
            Log.e("ChangeTabColorBrodRec", changeTabColor + "");
            changeTabColor(changeTabColor);
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        String CHANGE_TAB_COLOR_BROADCAST_ACTION = "io.zeroxp.pointofinterestgmaps.CHANGE_TAB_COLOR";

        IntentFilter filter = new IntentFilter(CHANGE_TAB_COLOR_BROADCAST_ACTION);
        ChangeTabColorBroadcastReceiver changeTabColorBroadcastReceiver = new ChangeTabColorBroadcastReceiver();
        getActivity().registerReceiver(changeTabColorBroadcastReceiver, filter);

    }
}
