package com.example.mohamed.gradpro;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class SearchGroupsRecyclerAdepter extends RecyclerView.Adapter<SearchGroupsRecyclerAdepter.ViewHolder> {

    private ArrayList<Map<String,String>> searchs;
    private Context context;
    private LayoutInflater layoutInflater;

    public SearchGroupsRecyclerAdepter(ArrayList<Map<String,String>> searchs  , Context context){
        this.searchs = searchs;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.group_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Map<String,String> getRecipes= searchs.get(position);

        holder.subject.setText(getRecipes.get("subject"));
        holder.background_imgage.setImageResource(R.drawable.bg1);
        holder.teacher_name.setText(getRecipes.get("teacher"));
        holder.level.setText(getRecipes.get("level"));
        holder.num.setText(getRecipes.get("num"));
        holder.city.setText(getRecipes.get("city"));
        holder.price.setText(getRecipes.get("price"));

    }

    @Override
    public int getItemCount() {
        return searchs.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener {

        private FragmentManager fragmentManager;
        TextView subject;
        ImageView background_imgage;
        TextView teacher_name;
        TextView level;
        TextView num;
        TextView city;
        TextView price;


        public ViewHolder(View itemView){
            super(itemView);

            subject=itemView.findViewById(R.id.sub);
            background_imgage=itemView.findViewById(R.id.backimg);
            teacher_name=itemView.findViewById(R.id.teacher);
            level=itemView.findViewById(R.id.lev);
            num=itemView.findViewById(R.id.num_student);
            city=itemView.findViewById(R.id.city);
            price=itemView.findViewById(R.id.price);



        }

        @Override
        public void onClick(View v) {

        }

        @Override
        public boolean onLongClick(View v) {
            return false;
        }
    }

}
