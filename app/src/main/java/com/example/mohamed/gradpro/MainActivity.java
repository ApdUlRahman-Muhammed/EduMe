package com.example.mohamed.gradpro;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity {

    Spinner search_spinner;
    ArrayAdapter<CharSequence>adapter;
    String subject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        search_spinner =findViewById(R.id.sp_search);
        adapter= ArrayAdapter.createFromResource(this,R.array.subjects,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        search_spinner.setAdapter(adapter);



    }


    public void click_search(View view) {

        Intent intent=new Intent(this,SearchActivity.class);
        startActivity(intent);
    }

    public void Click_filter(View v) {

        Filter_dialog filter_dialog =new Filter_dialog();
        filter_dialog.show(getSupportFragmentManager(),"Filters");
    }

    public void click_signin(View view) {
        Intent myintent=new Intent(this,SigninActivity.class);
        startActivity(myintent);

    }
    public void click_signup(View view) {
        Intent myintent=new Intent(this,SignupActivity.class);
        startActivity(myintent);
    }

}
