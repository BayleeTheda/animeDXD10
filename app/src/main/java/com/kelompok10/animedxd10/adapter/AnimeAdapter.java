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
import com.kelompok10.animedxd10.DetailPageFragment;

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

        // ketika item di klik
        holder.itemView.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("title", anime.getTitle());
            bundle.putString("genre", anime.getGenre());
            bundle.putString("synopsis", anime.getDescription());
            bundle.putInt("image", anime.getImageResId());

            DetailPageFragment detailFragment = new DetailPageFragment();
            detailFragment.setArguments(bundle);

            // ganti fragment
            FragmentActivity activity = (FragmentActivity) v.getContext();
            activity.getSupportFragmentManager().beginTransaction()
                    .replace(R.id.flFragment, detailFragment) // fragment_container = ID container di activity_main.xml
                    .addToBackStack(null) // supaya bisa back
                    .commit();
        });
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
