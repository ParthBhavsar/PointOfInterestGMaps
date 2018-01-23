package io.zeroxp.pointofinterestgmaps;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by parthbhavsar on 2018-01-22.
 */

public class DataCustomViewPager extends ViewPager {

    private boolean enabled;

    public DataCustomViewPager(Context context, boolean enabled) {
        super(context);
        this.enabled = enabled;
        setMyScroller();
    }

    public DataCustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.enabled = true;
        setMyScroller();
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (this.enabled)
        {
            return super.onTouchEvent(ev);
        }

        return false;
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        // Never allow swiping to switch between pages
        
        if (this.enabled)
        {
            return super.onInterceptTouchEvent(ev);
        }

        return false;
    }

    public void setPagingEnabled(boolean enabled)
    {
        this.enabled = enabled;
    }





    //down one is added for smooth scrolling

    private void setMyScroller() {
        try {
            Class<?> viewpager = ViewPager.class;
            Field scroller = viewpager.getDeclaredField("mScroller");
            scroller.setAccessible(true);
            scroller.set(this, new MyScroller(getContext()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class MyScroller extends Scroller {
        public MyScroller(Context context) {
            super(context, new DecelerateInterpolator());
        }

        @Override
        public void startScroll(int startX, int startY, int dx, int dy, int duration) {
            super.startScroll(startX, startY, dx, dy, 350 /*1 secs*/);
        }


    }
}
