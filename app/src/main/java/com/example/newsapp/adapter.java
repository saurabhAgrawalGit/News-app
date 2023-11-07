package com.example.newsapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class adapter  extends RecyclerView.Adapter<adapter.ViewHolder> {

    Context context;
    ArrayList<ModelClass> modelClassesList;

    public adapter(Context context, ArrayList<ModelClass> modelClasses) {
        this.context = context;
        this.modelClassesList = modelClasses;
    }

    @NonNull
    @Override
    public adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View mview = LayoutInflater.from(context).inflate(R.layout.news_view,parent,false);
     return new ViewHolder(mview);
    }

    @Override
    public void onBindViewHolder(@NonNull adapter.ViewHolder holder, int position) {
        holder.heading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Intent intent=new Intent(context,webView.class);
               // intent.putExtra("url",modelClassesList.get(position).getUrl());
               // context.startActivities(new Intent[]{intent});

            }

        });

        holder.heading.setText(modelClassesList.get(position).getTitle());
        holder.des.setText(modelClassesList.get(position).getDescription());
        Glide.with(context).load(modelClassesList.get(position).getUrlToImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return modelClassesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView heading , des,a,b,c;
        ImageView imageView;
        public ViewHolder(@NonNull View view)
        {
            super(view);
            heading=view.findViewById(R.id.headline);
            des=view.findViewById(R.id.des);
            imageView=view.findViewById(R.id.img);
        }
    }
}
