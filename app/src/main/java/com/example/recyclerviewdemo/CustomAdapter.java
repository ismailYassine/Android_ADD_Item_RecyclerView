package com.example.recyclerviewdemo;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    ArrayList<Person> people;
    Drawable icon;

    public CustomAdapter(ArrayList<Person> people, Drawable icon){
        this.people = people;
        this.icon = icon;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView firstName;
        ImageView myImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            firstName = itemView.findViewById(R.id.tvFirstName);
            myImage = itemView.findViewById(R.id.myicon);
        }

        public TextView getFirstName(){
            return firstName;
        }
        public ImageView getIcon(){
            return myImage;
        }
    }

    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {

    holder.getFirstName().setText(people.get(position).firstName + ", " + people.get(position).lastName);
    holder.getIcon().setBackground(icon);
    }

    @Override
    public int getItemCount() {
        return people.size();
    }
}
