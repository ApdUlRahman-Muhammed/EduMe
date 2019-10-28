package com.example.mohamed.gradpro;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {

    Button notification;
    Button massage;
    Button contact_us;


    public MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_menu, container, false);
        notification=view.findViewById(R.id.pup_notification);
        massage=view.findViewById(R.id.pup_massage);
        contact_us=view.findViewById(R.id.pup_contact_us);

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Notification_dialog notification =new Notification_dialog();
                notification.show(getChildFragmentManager(),"Notification");
            }
        });

        massage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Massages_dialog massages_dialog =new Massages_dialog();
                massages_dialog.show(getChildFragmentManager(),"massages");
            }
        });

        contact_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContactUs_dialog contactus_dialog =new ContactUs_dialog();
                contactus_dialog.show(getChildFragmentManager(),"contact us");
            }
        });

        return view;
    }

}
