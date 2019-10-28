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

public class TeacherRecAd extends RecyclerView.Adapter<TeacherRecAd.ViewHolder> {

    private ArrayList<Map<String,String>> teahers;
    private Context context;
    private LayoutInflater layoutInflater;

    public TeacherRecAd(ArrayList<Map<String, String>> teahers , Context context) {
        this.teahers = teahers;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.teacher_item,parent,false);
        return new ViewHolder(view);    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Map<String,String> get_posts= teahers.get(position);

        holder.name.setText(get_posts.get("name"));
        holder.pro_imgage.setImageResource(R.drawable.pro);
    }

    @Override
    public int getItemCount() {
        return teahers.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        ImageView pro_imgage;


        public ViewHolder(View itemView){
            super(itemView);

            name=itemView.findViewById(R.id.rec_teacher_name);
            pro_imgage=itemView.findViewById(R.id.rec_pro_image);




        }
    }
}
