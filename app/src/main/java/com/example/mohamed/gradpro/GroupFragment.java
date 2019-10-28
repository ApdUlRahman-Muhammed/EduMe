package com.example.mohamed.gradpro;


import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class GroupFragment extends Fragment implements AboutTabFragment.OnFragmentInteractionListener,ActivityproFragment.OnFragmentInteractionListener,SettingproFragment.OnFragmentInteractionListener{

    public GroupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_group, container, false);

        TabLayout tabLayout=view.findViewById(R.id.tablay_gro);
        tabLayout.addTab(tabLayout.newTab().setText("Group Info"));
        tabLayout.addTab(tabLayout.newTab().setText("Activity"));
        tabLayout.addTab(tabLayout.newTab().setText("Student"));
        tabLayout.addTab(tabLayout.newTab().setText("pending Student"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager gro_viewPager=view.findViewById(R.id.viewpager_gro);

        final GroupsPagerAdapter groPagerAdepter =new GroupsPagerAdapter(getChildFragmentManager(),tabLayout.getTabCount());
        gro_viewPager.setAdapter(groPagerAdepter);

        gro_viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                gro_viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return view;

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
