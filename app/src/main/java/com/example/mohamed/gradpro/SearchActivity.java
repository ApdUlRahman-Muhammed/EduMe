package com.example.mohamed.gradpro;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SearchActivity extends AppCompatActivity{

    Spinner search_spinner;
    ArrayAdapter<CharSequence>arrayAdapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private SearchGroupsRecyclerAdepter adapter;
    private ArrayList<Map<String,String>> searchs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_search);

//        String subject=getIntent().getStringExtra("subj");

        search_spinner =findViewById(R.id.sap_search);
        arrayAdapter= ArrayAdapter.createFromResource(this,R.array.subjects,android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        search_spinner.setAdapter(arrayAdapter);

        searchs  = new ArrayList<>();
        recyclerView= findViewById(R.id.search_recycler);
        layoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        for (int i = 0;i<16;i++){

            Map<String,String> temp =new HashMap<>();

            temp.put("subject","English"+i);
            temp.put("teacher","MR : mohamed salah");
            temp.put("level"," level 2");
            temp.put("num"," 8/15");
            temp.put("city","Tagmo3 5");
            temp.put("price"," 10 Pound/L");

            searchs.add(temp);

        }
        adapter = new SearchGroupsRecyclerAdepter( searchs,this);
        recyclerView.setAdapter(adapter);


    }


        public void Click_filter(View v) {

            Filter_dialog filter_dialog =new Filter_dialog();
            filter_dialog.show(getSupportFragmentManager(),"Filters");
        }

}
