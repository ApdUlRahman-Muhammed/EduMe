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
public class Gro_studentFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private StudentRVAdapter adapter;
    private ArrayList<Map<String,String>> student;

    public Gro_studentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view=inflater.inflate(R.layout.fragment_gro_student, container, false);

        student  = new ArrayList<>();
        recyclerView= view.findViewById(R.id.studentrecycler);
        layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        for (int i = 0;i<15;i++){

            Map<String,String> temp =new HashMap<>();

            temp.put("name"," mohamed salah");
            temp.put("join_time","Join at 2/4/2018");

            student.add(temp);

        }
        adapter = new StudentRVAdapter( student,getContext());
        recyclerView.setAdapter(adapter);
        return view;

    }

}
