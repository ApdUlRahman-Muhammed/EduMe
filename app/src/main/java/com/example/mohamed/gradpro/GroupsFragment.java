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
public class GroupsFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private GroupsRecyclerAdepter adapter;
    private ArrayList<Map<String,String>> groups;

    public GroupsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_groups, container, false);

        groups  = new ArrayList<>();
        recyclerView= view.findViewById(R.id.groups_recycler);
        layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        for (int i = 0;i<15;i++){

            Map<String,String> temp =new HashMap<>();

            temp.put("subject","English"+i);
            temp.put("teacher","MR : mohamed salah");
            temp.put("level"," level 2");
            temp.put("num"," 8/15");
            temp.put("city","Tagmo3 5");
            temp.put("price"," 10 Pound/L");


            groups.add(temp);

        }
        adapter = new GroupsRecyclerAdepter( groups,getActivity(),getActivity().getSupportFragmentManager());
        recyclerView.setAdapter(adapter);

        return view;
    }

}
