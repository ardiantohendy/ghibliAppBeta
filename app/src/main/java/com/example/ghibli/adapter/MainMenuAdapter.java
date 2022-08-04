package com.example.ghibli.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ghibli.R;
import com.example.ghibli.data.RecyclerviewInterface;
import com.example.ghibli.model.GhibliMovies;

import java.util.ArrayList;

public class MainMenuAdapter extends RecyclerView.Adapter<MainMenuAdapter.MyViewHolder> {
    private final RecyclerviewInterface recyclerviewInterface;
    private ArrayList<GhibliMovies> ghibliMoviesArrayList;
    private Context context;

    public MainMenuAdapter(ArrayList<GhibliMovies> ghibliMoviesArrayList, Context context, RecyclerviewInterface recyclerviewInterface) {
        this.ghibliMoviesArrayList = ghibliMoviesArrayList;
        this.context = context;
        this.recyclerviewInterface = recyclerviewInterface;
    }

    @NonNull
    @Override
    public MainMenuAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_rec_film, parent, false);
        return new MainMenuAdapter.MyViewHolder(view, recyclerviewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull MainMenuAdapter.MyViewHolder holder, int position) {
        holder.textViewTitle.setText(ghibliMoviesArrayList.get(position).getTitle());
        holder.imageCardView.setImageResource(ghibliMoviesArrayList.get(position).getImageCardInt());
    }

    @Override
    public int getItemCount() {
        return ghibliMoviesArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle;
        ImageView imageCardView;
        public MyViewHolder(@NonNull View itemView, RecyclerviewInterface recyclerviewInterface) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            imageCardView = itemView.findViewById(R.id.imageCardView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(recyclerviewInterface != null) {
                        int pos = getAdapterPosition();
                        if(pos != RecyclerView.NO_POSITION) {
                            recyclerviewInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}
