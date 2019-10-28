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

public class PostRecAd extends RecyclerView.Adapter<PostRecAd.ViewHolder> {

    private ArrayList<Map<String,String>> posts;
    private Context context;
    private LayoutInflater layoutInflater;

    public PostRecAd(ArrayList<Map<String, String>> posts , Context context) {
        this.posts = posts;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item_card,parent,false);
        return new ViewHolder(view);    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Map<String,String> get_posts= posts.get(position);

        holder.name.setText(get_posts.get("name"));
        holder.group.setText(get_posts.get("group"));
        holder.profile_imgage.setImageResource(R.drawable.pro);
        holder.post_imgage.setImageResource(R.drawable.logo);
        //Glide.with(context).load(get_posts.get("Image")).into(holder.imgage01);
        //viewHolder.desc.setText(get_posts.get("desc"));

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView group;
        ImageView profile_imgage;
        ImageView post_imgage;


        public ViewHolder(View itemView){
            super(itemView);

            name=itemView.findViewById(R.id.name);
            group=itemView.findViewById(R.id.group_name);
            profile_imgage=itemView.findViewById(R.id.profileimage);
            post_imgage=itemView.findViewById(R.id.postimage);




        }
    }
}
