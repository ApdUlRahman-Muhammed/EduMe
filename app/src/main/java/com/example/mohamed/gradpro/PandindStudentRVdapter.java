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

public class PandindStudentRVdapter extends RecyclerView.Adapter<PandindStudentRVdapter.ViewHolder> {

    private ArrayList<Map<String,String>> pandstudent;
    private Context context;
    private LayoutInflater layoutInflater;

    public PandindStudentRVdapter(ArrayList<Map<String, String>> pandstudent , Context context) {
        this.pandstudent = pandstudent;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.pending_student_item,parent,false);
        return new ViewHolder(view);    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Map<String,String> get_posts= pandstudent.get(position);

        holder.name.setText(get_posts.get("name"));
        holder.profile_image.setImageResource(R.mipmap.ic_launcher_round);
        holder.pend_time.setText(get_posts.get("pending_time"));

    }

    @Override
    public int getItemCount() {
        return pandstudent.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        ImageView profile_image;
        TextView pend_time;
        //ImageView accepted;
        //ImageView refuse;



        public ViewHolder(View itemView){
            super(itemView);

            name=itemView.findViewById(R.id.ps_name);
            profile_image=itemView.findViewById(R.id.psp_image);
            pend_time=itemView.findViewById(R.id.pending_time);




        }
    }
}