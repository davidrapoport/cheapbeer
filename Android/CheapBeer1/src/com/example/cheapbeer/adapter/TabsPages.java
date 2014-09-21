package com.example.cheapbeer.adapter;
import com.example.cheapbeer.GoPageView;
import com.example.cheapbeer.MapPageView;
import com.example.cheapbeer.ListPageView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
 
public class TabsPages extends FragmentPagerAdapter {
 
    public TabsPages(FragmentManager fm) {
        super(fm);
    }
 
    @Override
    public Fragment getItem(int index) {
 
        switch (index) {
        case 0:
            // Top Rated fragment activity
            return new GoPageView();
        case 1:
            // Games fragment activity
            return new MapPageView();
        case 2:
            // Movies fragment activity
            return new ListPageView();
        }
 
        return null;
    }
 
    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 3;
    }
 
}