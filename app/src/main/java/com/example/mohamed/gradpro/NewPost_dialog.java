package com.example.mohamed.gradpro;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class NewPost_dialog extends AppCompatDialogFragment {

    Spinner groups_spinner;
    ArrayAdapter<CharSequence> arrayAdapter;
    Button cancle;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final AlertDialog.Builder builder =new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.dialog_new_post,null);
        builder.setView(view).setTitle("add new post");

        groups_spinner =view.findViewById(R.id.sp_sg);
        arrayAdapter= ArrayAdapter.createFromResource(getContext(),R.array.groubs,android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        groups_spinner.setAdapter(arrayAdapter);

        cancle=view.findViewById(R.id.puplish_cancel);
        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setCancelable(true);
            }
        });

        return builder.create();
    }
}
