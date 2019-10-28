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
public class Profile2Fragment extends Fragment implements AboutTabFragment.OnFragmentInteractionListener,ActivityproFragment.OnFragmentInteractionListener,SettingproFragment.OnFragmentInteractionListener{


    public Profile2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_profile2, container, false);
        TabLayout tabLayout_profile=view.findViewById(R.id.tablay_profile);
        tabLayout_profile.addTab(tabLayout_profile.newTab().setText("Info"));
        tabLayout_profile.addTab(tabLayout_profile.newTab().setText("Activity"));
        tabLayout_profile.addTab(tabLayout_profile.newTab().setText("Setting"));
        tabLayout_profile.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager profile_viewPager=view.findViewById(R.id.viewpager_profile);

        final ProfilePagerAdepter proPagerAdepter =new ProfilePagerAdepter(getChildFragmentManager(),tabLayout_profile.getTabCount());
        profile_viewPager.setAdapter(proPagerAdepter);

        profile_viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout_profile));
        tabLayout_profile.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                profile_viewPager.setCurrentItem(tab.getPosition());
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