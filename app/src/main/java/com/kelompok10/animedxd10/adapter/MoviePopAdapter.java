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

public class MoviePopAdapter extends RecyclerView.Adapter<MoviePopAdapter.MyViewHolder> {

    private final Context context;
    private final List<MovieCard> listMovie;
    private Dialog dialog;

    interface Dialog{
        void onclick(int position);
    }

    public MoviePopAdapter(Context context, List<MovieCard> listMovie){
        this.context = context;
        this.listMovie = listMovie;
    }

    @NonNull
    @Override
    public MoviePopAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.popular_card, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviePopAdapter.MyViewHolder holder, int position) {
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

        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            title = itemView.findViewById(R.id.card_pop_title);
            desc = itemView.findViewById(R.id.card_pop_desc);
            cover = itemView.findViewById(R.id.card_pop_cover);
        }
    }
}
