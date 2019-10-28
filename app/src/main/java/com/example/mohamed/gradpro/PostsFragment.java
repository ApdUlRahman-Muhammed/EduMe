package com.example.mohamed.gradpro;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class PostsFragment extends Fragment {


    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private PostRecAd adapter;
    private ArrayList<Map<String,String>> posts;
    private FloatingActionButton fabpost;

    public PostsFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view = inflater.inflate(R.layout.fragment_posts, container, false);
        posts  = new ArrayList<>();
        recyclerView= view.findViewById(R.id.recycler);
        layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        for (int i = 0;i<7;i++){

            Map<String,String> temp =new HashMap<>();

            temp.put("name"," mohamed salah");
            temp.put("group"," ");


            posts.add(temp);

        }
        adapter = new PostRecAd( posts,getContext());
        recyclerView.setAdapter(adapter);

        fabpost =view.findViewById(R.id.fab_post);
        fabpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NewPost_dialog post_dialog =new NewPost_dialog();
                post_dialog.show(getChildFragmentManager(),"adding new post");
            }
        });

        return view;

    }
}
