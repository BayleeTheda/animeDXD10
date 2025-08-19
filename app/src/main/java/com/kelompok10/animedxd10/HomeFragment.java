package com.kelompok10.animedxd10.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.kelompok10.animedxd10.DetailPage;
import com.kelompok10.animedxd10.R;
import com.kelompok10.animedxd10.model.Anime;

import java.util.List;

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
        holder.tvTitle.setText(anime.getTitle());
        holder.tvGenre.setText(anime.getGenre());
        holder.imgCover.setImageResource(anime.getImageResId());

        holder.itemView.setOnClickListener(v -> {
            // Kirim data ke DetailPage
            Bundle bundle = new Bundle();
            bundle.putString("title", anime.getTitle());
            bundle.putString("genre", anime.getGenre());
            bundle.putString("synopsis", anime.getSynopsis());
            bundle.putInt("image", anime.getImageResId());

            DetailPage detailPage = new DetailPage();
            detailPage.setArguments(bundle);

            ((FragmentActivity) v.getContext()).getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, detailPage)
                    .addToBackStack(null)
                    .commit();
        });
    }

    @Override
    public int getItemCount() {
        return animeList.size();
    }

    static class AnimeViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvGenre;
        ImageView imgCover;

        public AnimeViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvAnimeTitle);
            tvGenre = itemView.findViewById(R.id.tvAnimeGenre);
            imgCover = itemView.findViewById(R.id.imgAnimeCover);
        }
    }
}
