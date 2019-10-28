package com.example.mohamed.gradpro;

import android.support.v4.app.Fragment;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentActivity;

import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;


public class Main_page extends FragmentActivity{

    BottomNavigationViewEx navigation;
   private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            if (!item.isChecked()){
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.nav_home:
                       fragment=new HomeFragment();
                        break;
                    case R.id.nav_groups:
                       fragment=new GroupsFragment();
                        break;
                    case R.id.nav_profile:
                        fragment=new Profile2Fragment();
                        break;
                    case R.id.nav_menu:
                        fragment=new MenuFragment();
                        break;
                }

                if(fragment != null){
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragmentmain, fragment );
                    for (int i = 0 ; i < getSupportFragmentManager().getBackStackEntryCount();i++){
                        getSupportFragmentManager().popBackStackImmediate();
                    }
                    transaction.addToBackStack(fragment.getTag());
                    transaction.commit();
                    return true;
                }
            }
            return false;
        }

    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragmentmain, new HomeFragment())
                    .commit();
        }



        ///////////////////// BottomNavigationViewEx navigation ////////////////
        navigation =findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        //navigation.enableAnimation(false);
        //navigation.enableShiftingMode(false);
        //navigation.enableItemShiftingMode(false);


    }

}
