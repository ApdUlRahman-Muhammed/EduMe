package com.example.mohamed.gradpro;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class NotificationRecAd extends RecyclerView.Adapter<NotificationRecAd.ViewHolder> {

    private ArrayList<Map<String,String>> notification;
    private Context context;
    private LayoutInflater layoutInflater;

    public NotificationRecAd(ArrayList<Map<String, String>> notification , Context context) {
        this.notification = notification;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_item,parent,false);
        return new ViewHolder(view);    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Map<String,String> get_posts= notification.get(position);

        holder.notifi.setText(get_posts.get("notifi"));
        holder.pro_imgage.setImageResource(R.drawable.pro);
    }

    @Override
    public int getItemCount() {
        return notification.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView notifi;
        ImageView pro_imgage;


        public ViewHolder(View itemView){
            super(itemView);

            notifi=itemView.findViewById(R.id.notifi);
            pro_imgage=itemView.findViewById(R.id.notifi_image);




        }
    }
}
