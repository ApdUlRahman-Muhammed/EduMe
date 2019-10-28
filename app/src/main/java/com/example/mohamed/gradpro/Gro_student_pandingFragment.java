package com.example.mohamed.gradpro;


import android.os.Bundle;
import android.support.v4.app.Fragment;
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
public class Gro_student_pandingFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private PandindStudentRVdapter adapter;
    private ArrayList<Map<String,String>> pandstudent;

    public Gro_student_pandingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_gro_student_panding, container, false);
        pandstudent  = new ArrayList<>();
        recyclerView= view.findViewById(R.id.pandstudrecycler);
        layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        for (int i = 0;i<4;i++){

            Map<String,String> temp =new HashMap<>();

            temp.put("name"," mohamed salah");
            temp.put("pending_time","at 3/4/2018");


            pandstudent.add(temp);

        }
        adapter = new PandindStudentRVdapter( pandstudent,getContext());
        recyclerView.setAdapter(adapter);
        return view;
    }

}
