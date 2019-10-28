package com.example.mohamed.gradpro;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class Filter_dialog extends AppCompatDialogFragment {

    Spinner cities_spinner;
    Spinner levels_spinner;
    Spinner prices_spinner;

    ArrayAdapter<CharSequence> arrayAdapter1;
    ArrayAdapter<CharSequence> arrayAdapter2;
    ArrayAdapter<CharSequence> arrayAdapter3;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_filter, null);
        builder.setView(view).setTitle("Filters");

        cities_spinner = view.findViewById(R.id.sp_city);
        levels_spinner = view.findViewById(R.id.sp_level);
        prices_spinner = view.findViewById(R.id.sp_price);

        arrayAdapter1 = ArrayAdapter.createFromResource(getContext(), R.array.cites, android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter2= ArrayAdapter.createFromResource(getContext(), R.array.level, android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter3 = ArrayAdapter.createFromResource(getContext(), R.array.prices, android.R.layout.simple_spinner_dropdown_item);

        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        cities_spinner.setAdapter(arrayAdapter1);
        levels_spinner.setAdapter(arrayAdapter2);
        prices_spinner.setAdapter(arrayAdapter3);

        return builder.create();
    }
}
