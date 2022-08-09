package com.example.movieappwithmvvm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import model.ListModel;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    private Context context;
    private List<ListModel> listModelList;


    public ListAdapter(Context context , List<ListModel>listModelList){
        this.context = context;
        listModelList = listModelList;

    }

    public void setList(List<ListModel>listModelList){
        this.listModelList = listModelList;
        notifyDataSetChanged();

    }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.sample_layout,parent,false);

        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {

        holder.textView.setText(listModelList.get(position).getTitle());
        Glide.with(context).load(listModelList.get(position).getImage()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {

        if(listModelList!= null){
            return  listModelList.size();
        }
        return 0;
    }

    public class ListViewHolder extends  RecyclerView.ViewHolder{

        TextView textView ;
        ImageView imageView;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }


}
