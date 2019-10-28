package com.example.mohamed.gradpro;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Massages_dialog extends AppCompatDialogFragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private MassagesRecAd adapter;
    private ArrayList<Map<String,String>> massages;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final AlertDialog.Builder builder =new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.dialog_massages,null);
        builder.setView(view).setTitle("massages");

        massages  = new ArrayList<>();
        recyclerView= view.findViewById(R.id.massages_recycler);
        layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        for (int i = 0;i<10;i++){
            Map<String,String> temp =new HashMap<>();
            temp.put("massname"," mohamed salah");
            temp.put("masscont","Massage conten"+i);
            massages.add(temp);
        }
        adapter = new MassagesRecAd( massages,getContext());
        recyclerView.setAdapter(adapter);

        return builder.create();
    }
}
