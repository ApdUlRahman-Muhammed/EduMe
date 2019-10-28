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

public class MassagesRecAd extends RecyclerView.Adapter<MassagesRecAd.ViewHolder> {

    private ArrayList<Map<String,String>> massages;
    private Context context;
    private LayoutInflater layoutInflater;

    public MassagesRecAd(ArrayList<Map<String, String>> teahers , Context context) {
        this.massages = teahers;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.massage_item,parent,false);
        return new ViewHolder(view);    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Map<String,String> get_posts= massages.get(position);

        holder.massname.setText(get_posts.get("massname"));
        holder.masscont.setText(get_posts.get("masscont"));
        holder.pro_imgage.setImageResource(R.drawable.pro);
    }

    @Override
    public int getItemCount() {
        return massages.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView massname;
        TextView masscont;
        ImageView pro_imgage;


        public ViewHolder(View itemView){
            super(itemView);

            massname=itemView.findViewById(R.id.mass_name);
            masscont=itemView.findViewById(R.id.masscont);
            pro_imgage=itemView.findViewById(R.id.mass_image);




        }
    }
}
