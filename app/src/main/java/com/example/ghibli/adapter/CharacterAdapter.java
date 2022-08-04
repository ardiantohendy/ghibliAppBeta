package com.example.ghibli.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ghibli.R;
import com.example.ghibli.data.RecyclerViewCharInterface;
import com.example.ghibli.model.People;

import java.util.ArrayList;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.MyViewHolder> {
    private final RecyclerViewCharInterface recyclerviewCharInterface;
    private ArrayList<People> peopleArrayList;
    private Context context;

    public CharacterAdapter(ArrayList<People> peopleArrayList, Context context, RecyclerViewCharInterface recyclerviewCharInterface) {
        this.peopleArrayList = peopleArrayList;
        this.context = context;
        this.recyclerviewCharInterface = recyclerviewCharInterface;
    }

    @NonNull
    @Override
    public CharacterAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_rec_character, parent, false);
        return new CharacterAdapter.MyViewHolder(view, recyclerviewCharInterface);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull CharacterAdapter.MyViewHolder holder, int position) {
        holder.charRecName.setText(peopleArrayList.get(position).getName());
        holder.txtNameInside.setText("Name: " + peopleArrayList.get(position).getName());
//        holder.txtGenderInside.setText("Gender: " + peopleArrayList.get(position).getGender());
//        holder.txtAgeInside.setText("Age: " + peopleArrayList.get(position).getAge());
//        holder.txtEyeInside.setText("Eye Color: " + peopleArrayList.get(position).getEye_color());
//        holder.txtHairInside.setText("Hair Color: " + peopleArrayList.get(position).getHair_color());
//        holder.imageChar.setImageResource(R.drawable.logo2);
    }


    @Override
    public int getItemCount() {
        return peopleArrayList.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView charRecName, txtNameInside, txtGenderInside, txtAgeInside, txtEyeInside, txtHairInside, txtFilmInside;
        ImageView imageChar;
        public MyViewHolder(@NonNull View itemView, RecyclerViewCharInterface recyclerviewCharInterface) {
            super(itemView);
            charRecName = itemView.findViewById(R.id.charRecName);
            txtNameInside = itemView.findViewById(R.id.txtNameInside);
//            txtGenderInside = itemView.findViewById(R.id.txtGenderInside);
//            txtAgeInside = itemView.findViewById(R.id.txtAgeInside);
//            txtEyeInside = itemView.findViewById(R.id.txtEyeInside);
//            txtHairInside = itemView.findViewById(R.id.txtHairInside);
//            txtFilmInside = itemView.findViewById(R.id.txtFilmInside);
//            imageChar = itemView.findViewById(R.id.imageChar);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(recyclerviewCharInterface != null) {
                        int pos = getAdapterPosition();
                        if(pos != RecyclerView.NO_POSITION) {
                            recyclerviewCharInterface.onItemCharClick(pos);
                        }
                    }
                }
            });
        }
    }
}
