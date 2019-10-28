package com.example.mohamed.gradpro;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class ProfilePagerAdepter extends FragmentStatePagerAdapter {
    int nooftab;

    public ProfilePagerAdepter(FragmentManager fm , int nooftab){
        super(fm);
        this.nooftab=nooftab;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                AboutTabFragment tab1 = new AboutTabFragment();
                return tab1;

            case 1:
                ActivityproFragment tab2 = new ActivityproFragment();
                return tab2;

            case 2:
                SettingproFragment tab3 = new SettingproFragment();
                return tab3;
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return nooftab;
    }
}
