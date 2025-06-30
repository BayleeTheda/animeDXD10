package com.kelompok10.animedxd10;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kelompok10.animedxd10.adapter.AnimeAdapter;
import com.kelompok10.animedxd10.model.Anime;

import java.util.ArrayList;
import java.util.List;

public class AnimeListFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<Anime> animeList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_anime_list, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewAnime);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        animeList = getAnimeData();
        AnimeAdapter adapter = new AnimeAdapter(animeList);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private List<Anime> getAnimeData() {
        List<Anime> list = new ArrayList<>();
        list.add(new Anime("Attack on Titan", "Action, Drama, Fantasy, Post-apocalyptic",
                "Manusia hidup di balik tembok raksasa untuk melindungi...",
                R.drawable.cover_anime1));
        list.add(new Anime("Demon Slayer", "Action, Supernatural, Historical",
                "Tanjiro menjadi pembasmi iblis setelah keluarganya dibantai...",
                R.drawable.cover_anime2));
        list.add(new Anime("One Piece", "Action, Adventure, Fantasy",
                "Monkey D. Luffy dan kru bajaknya menjelajahi lautan...",
                R.drawable.cover_anime3));
        list.add(new Anime("My Hero Academia", "Action, Superhero, School, Sci-Fi",
                "Di dunia di mana semua orang punya kekuatan super...",
                R.drawable.cover_anime4));
        list.add(new Anime("Jujutsu Kaisen", "Action, Supernatural, Horror",
                "Yuji Itadori terlibat dalam dunia kutukan setelah menelan jari iblis Sukuna...",
                R.drawable.cover_anime5));
        list.add(new Anime("Tokyo Revengers", "Action, Drama, Supernatural, Delinquent",
                "Takemichi melakukan perjalanan waktu ke masa remajanya...",
                R.drawable.cover_anime6));
        list.add(new Anime("Chainsaw Man", "Action, Horror, Dark Fantasy",
                "Denji, pemuda miskin yang bersatu dengan iblis...",
                R.drawable.cover_anime7));
        list.add(new Anime("Spy X Family", "Comedy, Action, Slice of Life",
                "Seorang mata-mata harus membangun keluarga palsu...",
                R.drawable.cover_anime8));
        list.add(new Anime("Sword Art Online", "Sci-Fi, Action, Adventure, Romance",
                "Pemain terjebak dalam game VR mematikan...",
                R.drawable.cover_anime9));
        list.add(new Anime("Full Metal Alchemist", "Action, Adventure, Fantasy, Drama",
                "Dua bersaudara, Edward dan Alphonse, mencari Batu...",
                R.drawable.cover_anime10));

        return list;
    }
}
