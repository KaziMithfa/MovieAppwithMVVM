package com.example.movieappwithmvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.List;

import model.ListModel;
import viewmodel.ListViewModel;


public class MainActivity extends AppCompatActivity {

    RecyclerView  recyclerView;
    private List<ListModel>listModelList;
    private ListViewModel listViewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recylerviewId);
        LinearLayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        ListAdapter listAdapter = new ListAdapter(this,listModelList);
        recyclerView.setAdapter(listAdapter);

      listViewModel =   ViewModelProviders.of(this).get(ListViewModel.class);
      listViewModel.getMovieListObserver().observe(this, new Observer<List<ListModel>>() {
          @Override
          public void onChanged(List<ListModel> listModelList) {
              if(listModelList != null){

                  listAdapter.setList(listModelList);
              }



          }
      });

      listViewModel.makeApiCall();


    }
}