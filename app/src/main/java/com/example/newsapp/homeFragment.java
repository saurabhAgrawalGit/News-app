package com.example.newsapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class homeFragment extends Fragment {


   ArrayList<ModelClass> modelClassArrayList;
   adapter objAdapter;
   String country ="in";
   String api ="14f9b3ad155f45be9c4234a3c49ebf37";
   RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home,null);
        recyclerView=view.findViewById(R.id.recycler);
       modelClassArrayList= new ArrayList<>();
        findNews();
       recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
       objAdapter=new adapter(getContext(),modelClassArrayList);
       recyclerView.setAdapter(objAdapter);

       return  view;

    }

    private void findNews() {
        ApiUse.getApiInterface().getNews(country,100,api).enqueue(new Callback<MainNews>() {
            @Override
            public void onResponse(Call<MainNews> call, Response<MainNews> response) {
                modelClassArrayList.addAll(response.body().getArticles());
                objAdapter.notifyDataSetChanged();
                Log.e( "array one : ",modelClassArrayList.get(0).title);
            }

            @Override
            public void onFailure(Call<MainNews> call, Throwable t) {
                Log.e( "onFailure: ", t.toString());

            }
        });
    }
}