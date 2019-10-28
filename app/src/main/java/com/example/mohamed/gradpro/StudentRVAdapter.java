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

public class StudentRVAdapter extends RecyclerView.Adapter<StudentRVAdapter.ViewHolder> {

    private ArrayList<Map<String,String>> student;
    private Context context;
    private LayoutInflater layoutInflater;

    public StudentRVAdapter(ArrayList<Map<String, String>> student , Context context) {
        this.student = student;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.student_item,parent,false);
        return new ViewHolder(view);    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Map<String,String> get_posts= student.get(position);

        holder.name.setText(get_posts.get("name"));
        holder.profile_image.setImageResource(R.mipmap.ic_launcher_round);
        holder.join_time.setText(get_posts.get("join_time"));
        //

    }

    @Override
    public int getItemCount() {
        return student.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        ImageView profile_image;
        TextView join_time;
      //  ImageView setting_image;


        public ViewHolder(View itemView){
            super(itemView);

            name=itemView.findViewById(R.id.s_name);
            profile_image=itemView.findViewById(R.id.sp_image);
            join_time=itemView.findViewById(R.id.join_time);




        }
    }
}
