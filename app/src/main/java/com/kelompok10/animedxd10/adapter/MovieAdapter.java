package com.kelompok10.animedxd10.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kelompok10.animedxd10.R;
import com.kelompok10.animedxd10.model.MovieCard;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder>{
    private final Context context;
    private final List<MovieCard> listMovie;
    private Dialog dialog;

    interface Dialog{
        void onClick(int position);
    }

    public MovieAdapter(Context context, List<MovieCard> listMovie) {
        this.context = context;
        this.listMovie = listMovie;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recomendation_card, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText(listMovie.get(position).getTitle());
        holder.desc.setText(listMovie.get(position).getDesc());
        holder.cover.setImageDrawable(listMovie.get(position).getCover());
    }

    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        TextView desc;
        ImageView cover;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.card_recom_title);
            desc = itemView.findViewById(R.id.card_recom_desc);
            cover = itemView.findViewById(R.id.card_recom_cover);
        }
    }
}
