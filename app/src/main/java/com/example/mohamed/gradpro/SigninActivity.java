package com.example.mohamed.gradpro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SigninActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
    }
    public void click_signup(View view) {
        Intent myintent=new Intent(this,SignupActivity.class);
        startActivity(myintent);
    }


    public void signin(View view){
        Intent myintent=new Intent(this,Main_page.class);
        startActivity(myintent);
    }

}
