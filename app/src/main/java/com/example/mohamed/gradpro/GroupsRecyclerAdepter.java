package com.example.mohamed.gradpro;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;

public class GroupsRecyclerAdepter extends RecyclerView.Adapter<GroupsRecyclerAdepter.ViewHolder> {

    private ArrayList<Map<String,String>> groups;
    private Activity myActivity;
    private LayoutInflater layoutInflater;
    private FragmentManager fragmentManager;


    public GroupsRecyclerAdepter(ArrayList<Map<String,String>> groups  , Activity myActivity,FragmentManager fragmentManager){
        this.groups = groups;
        this.myActivity = myActivity;
        this.fragmentManager=fragmentManager;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.group_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Map<String,String> getRecipes= groups.get(position);

        holder.subject.setText(getRecipes.get("subject"));
        holder.background_imgage.setImageResource(R.drawable.bg1);
        holder.teacher_name.setText(getRecipes.get("teacher"));
        holder.level.setText(getRecipes.get("level"));
        holder.num.setText(getRecipes.get("num"));
        holder.city.setText(getRecipes.get("city"));
        holder.price.setText(getRecipes.get("price"));

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onclick(View view, int position, boolean isLongClick) {

                if (isLongClick){

                    Toast.makeText(myActivity,"long click",Toast.LENGTH_LONG).show();

                }else {
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragmentmain,new GroupFragment())
                            .addToBackStack("GroupsFragment")
                            .commit();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return groups.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener {

        TextView subject;
        ImageView background_imgage;
        TextView teacher_name;
        TextView level;
        TextView num;
        TextView city;
        TextView price;
        private ItemClickListener itemClickListener;


        public ViewHolder(View itemView){
            super(itemView);

            subject=itemView.findViewById(R.id.sub);
            background_imgage=itemView.findViewById(R.id.backimg);
            teacher_name=itemView.findViewById(R.id.teacher);
            level=itemView.findViewById(R.id.lev);
            num=itemView.findViewById(R.id.num_student);
            city=itemView.findViewById(R.id.city);
            price=itemView.findViewById(R.id.price);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);



        }

        public void setItemClickListener(ItemClickListener itemClickListener){
            this.itemClickListener=itemClickListener;
        }

        @Override
        public void onClick(View v) {

            itemClickListener.onclick(v,getAdapterPosition(),false);

        }

        @Override
        public boolean onLongClick(View v) {
            itemClickListener.onclick(v,getAdapterPosition(),true);
            return true;
        }
    }

}
