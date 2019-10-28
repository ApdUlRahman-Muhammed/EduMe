package com.example.mohamed.gradpro;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    Spinner search_spinner;
    ArrayAdapter<CharSequence> arrayAdapter;
    ImageView filter_image;
    ImageView search_image;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private PostRecAd adapter;
    private ArrayList<Map<String,String>> posts;
    private FloatingActionButton fabpost;
    private RecyclerView recyclerView2;
    private RecyclerView.LayoutManager layoutManager2;
    private TeacherRecAd adapter2;
    private ArrayList<Map<String,String>> teachers;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        search_spinner =view.findViewById(R.id.home_spinner_search);
        arrayAdapter= ArrayAdapter.createFromResource(getContext(),R.array.subjects,android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        search_spinner.setAdapter(arrayAdapter);

        filter_image =view.findViewById(R.id.home_search_filter);
        search_image =view.findViewById(R.id.image_home_search);

        search_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),SearchActivity.class));
            }
        });

        filter_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Filter_dialog filter_dialog =new Filter_dialog();
                filter_dialog.show(getChildFragmentManager(),"Filters");
            }
        });

        ///////////////////////////////

        posts  = new ArrayList<>();
        recyclerView= view.findViewById(R.id.actpost_recycler);
        layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        for (int i = 0;i<10;i++){
            Map<String,String> temp =new HashMap<>();
            temp.put("name"," mohamed salah");
            temp.put("group","> group"+i);
            posts.add(temp);
        }
        adapter = new PostRecAd( posts,getContext());
        recyclerView.setAdapter(adapter);
////////////////////////////////////////////////////////////////
        fabpost =view.findViewById(R.id.fab_home_post);
        fabpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NewPost_dialog post_dialog =new NewPost_dialog();
                post_dialog.show(getChildFragmentManager(),"adding new post");
            }
        });

        //////////////////////////////////

        teachers  = new ArrayList<>();
        recyclerView2= view.findViewById(R.id.best_teacher_recycler);
        layoutManager2=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView2.setLayoutManager(layoutManager2);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setItemAnimator(new DefaultItemAnimator());
        for (int i = 0;i<15;i++){
            Map<String,String> temp1 =new HashMap<>();
            temp1.put("name"," mohamed salah");
            teachers.add(temp1);
        }
        adapter2 = new TeacherRecAd( teachers,getContext());
        recyclerView2.setAdapter(adapter2);

        return view;
    }



}
