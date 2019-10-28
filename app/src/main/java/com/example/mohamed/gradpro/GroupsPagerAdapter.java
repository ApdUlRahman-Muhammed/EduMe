package com.example.mohamed.gradpro;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class GroupsPagerAdapter extends FragmentStatePagerAdapter {
    int nooftab;

    public GroupsPagerAdapter(FragmentManager fm , int nooftab){
        super(fm);
        this.nooftab=nooftab;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                Gro_infoFragment tab1 = new Gro_infoFragment();
                return tab1;

            case 1:
                PostsFragment tab2 = new PostsFragment();
                return tab2;

            case 2:
                Gro_studentFragment tab3 = new Gro_studentFragment();
                return tab3;
            case 3:
                Gro_student_pandingFragment tab4 = new Gro_student_pandingFragment();
                return tab4;
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return nooftab;
    }
}
