package com.example.mohamed.gradpro;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SliderActivity extends AppCompatActivity {

    private ViewPager mSliderViewPager;
    private LinearLayout mDotLayout;
    private TextView[] dotstv;
    private SliderAdapter sliderAdapter;
    private Button nextbtn;
    private Button skipbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!IsFirstTimeStartApp()){
            startmainactivity();
            finish();
        }

        setStatusBarTransprent();

        setContentView(R.layout.activity_welcame);

        mSliderViewPager=findViewById(R.id.viewpager);
        mDotLayout=findViewById(R.id.dot_layout);
        nextbtn=findViewById(R.id.nextbtn);
        skipbtn=findViewById(R.id.skiptbtn);

        sliderAdapter=new SliderAdapter(this);
        mSliderViewPager.setAdapter(sliderAdapter);

        setDotStatus(0);
        mSliderViewPager.addOnPageChangeListener(viewlistener);

    }

    public void onClick_nextbtn(View view) {
        int CurrentPage=mSliderViewPager.getCurrentItem()+1;
        if (CurrentPage < dotstv.length) {
            // move to next page
            mSliderViewPager.setCurrentItem(CurrentPage);
        }
        else
            startmainactivity();
    }

    public void onClick_skipbtn(View v) {
        startmainactivity();
    }

   private boolean IsFirstTimeStartApp(){
        SharedPreferences ref = getApplicationContext().getSharedPreferences("IntroSliderApp", Context.MODE_PRIVATE);
        return ref.getBoolean("FirstTimeStartFlag",true);
    }
    private void setFirstTimeStartStatus(boolean stt){
        SharedPreferences ref = getApplicationContext().getSharedPreferences("IntroSliderApp", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=ref.edit();
        editor.putBoolean("FirstTimeStartFlag",stt);
        editor.commit();

    }


    private void setDotStatus(int position){
        dotstv=new TextView[4];
        mDotLayout.removeAllViews();
        for (int i=0;i<dotstv.length;i++){
            dotstv[i]=new TextView(this);
            dotstv[i].setText(Html.fromHtml("&#8226;"));
            dotstv[i].setTextSize(35);
            dotstv[i].setTextColor(getResources().getColor(R.color.colorAccent));
            mDotLayout.addView(dotstv[i]);
        }
        if (dotstv.length>0){
            dotstv[position].setTextColor(getResources().getColor(R.color.colorPrimary));
        }
    }


     ViewPager.OnPageChangeListener viewlistener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            if (position==dotstv.length-1){
                nextbtn.setText("Start");
                skipbtn.setVisibility(View.GONE);
            }
            else {
                nextbtn.setText("next");
                skipbtn.setVisibility(View.VISIBLE);
            }
            setDotStatus(position);

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


    private void startmainactivity(){
        setFirstTimeStartStatus(false);
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }

    private void setStatusBarTransprent(){
        if (Build.VERSION.SDK_INT >=21){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE| View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            Window window =getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }
}
