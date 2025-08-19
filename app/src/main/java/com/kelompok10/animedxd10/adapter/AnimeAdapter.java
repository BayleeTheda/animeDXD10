package com.kelompok10.animedxd10.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kelompok10.animedxd10.R;
import com.kelompok10.animedxd10.model.Anime;

import java.util.List;

//new
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.kelompok10.animedxd10.DetailPage;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder> {

    private List<Anime> animeList;

    public AnimeAdapter(List<Anime> animeList) {
        this.animeList = animeList;
    }

    @NonNull
    @Override
    public AnimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_anime, parent, false);
        return new AnimeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimeViewHolder holder, int position) {
        Anime anime = animeList.get(position);
        holder.title.setText(anime.getTitle());
        holder.genre.setText("Genre: " + anime.getGenre());
        holder.description.setText(anime.getDescription());
        holder.image.setImageResource(anime.getImageResId());
    }

    @Override
    public int getItemCount() {
        return animeList.size();
    }

    public static class AnimeViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title, genre, description;

        public AnimeViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.animeImage);
            title = itemView.findViewById(R.id.animeTitle);
            genre = itemView.findViewById(R.id.animeGenre);
            description = itemView.findViewById(R.id.animeDescription);
        }
    }
}
