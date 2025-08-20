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
                "Manusia hidup di balik tembok raksasa untuk melindungi diri dari makhluk pemakan manusia bernama Titan. Seorang pemuda bernama Eren bertekad menghancurkan semua Titan setelah tragedi menimpa keluarganya.",
                R.drawable.cover_anime1));
        list.add(new Anime("Demon Slayer", "Action, Supernatural, Historical",
                "Tanjiro menjadi pembasmi iblis setelah keluarganya dibantai dan adik perempuannya berubah menjadi iblis. Ia berjuang mencari cara untuk mengembalikan adiknya menjadi manusia.",
                R.drawable.cover_anime2));
        list.add(new Anime("One Piece", "Action, Adventure, Fantasy",
                "Monkey D. Luffy dan kru bajak lautnya menjelajahi lautan untuk mencari harta karun legendaris One Piece agar Luffy bisa menjadi Raja Bajak Laut.",
                R.drawable.cover_anime3));
        list.add(new Anime("My Hero Academia", "Action, Superhero, School, Sci-Fi",
                "Di dunia di mana hampir semua orang memiliki kekuatan super (quirk), Izuku Midoriya yang lahir tanpa kekuatan berusaha menjadi pahlawan terbesar.",
                R.drawable.cover_anime4));
        list.add(new Anime("Jujutsu Kaisen", "Action, Supernatural, Horror",
                "\n" +
                        "Yuji Itadori terlibat dalam dunia kutukan setelah menelan jari iblis Sukuna dan kini harus bertarung melawan roh-roh terkutuk.",
                R.drawable.cover_anime5));
        list.add(new Anime("Tokyo Revengers", "Action, Drama, Supernatural, Delinquent",
                "\n" +
                        "Takemichi melakukan perjalanan waktu ke masa remajanya untuk menyelamatkan mantan pacarnya dari kematian yang disebabkan oleh geng kriminal di masa depan.",
                R.drawable.cover_anime6));
        list.add(new Anime("Chainsaw Man", "Action, Horror, Dark Fantasy",
                "Denji, pemuda miskin yang bersatu dengan iblis gergaji mesin, menjadi pemburu iblis untuk membayar utang dan mengejar hidup yang layak.",
                R.drawable.cover_anime7));
        list.add(new Anime("Spy X Family", "Comedy, Action, Slice of Life",
                "Seorang mata-mata harus membangun keluarga palsu sebagai bagian dari misinya — tanpa mengetahui bahwa \"istri\" dan \"anaknya\" juga punya rahasia masing-masing.",
                R.drawable.cover_anime8));
        list.add(new Anime("Sword Art Online", "Sci-Fi, Action, Adventure, Romance",
                "Pemain terjebak dalam game VR mematikan di mana kematian dalam game berarti kematian di dunia nyata. Kirito berjuang untuk bertahan hidup dan membebaskan semua pemain.",
                R.drawable.cover_anime9));
        list.add(new Anime("Full Metal Alchemist", "Action, Adventure, Fantasy, Drama",
                "\n" +
                        "Dua bersaudara, Edward dan Alphonse, mencari Batu Bertuah untuk memulihkan tubuh mereka setelah eksperimen alkimia yang gagal.",
                R.drawable.cover_anime10));

        return list;
    }
}
