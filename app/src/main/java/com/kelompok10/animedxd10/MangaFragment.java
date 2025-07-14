package com.kelompok10.animedxd10;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kelompok10.animedxd10.adapter.MoviePopAdapter;
import com.kelompok10.animedxd10.model.MovieCard;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MangaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MangaFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private List<MovieCard> moviePopList = new ArrayList<>();
    private RecyclerView recyclerViewPop;

    public MangaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MangaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MangaFragment newInstance(String param1, String param2) {
        MangaFragment fragment = new MangaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_manga, container, false);

        recyclerViewPop = view.findViewById(R.id.recyclerPopular);
        recyclerViewPop.setLayoutManager(new GridLayoutManager(this.getContext(), 2));
        recyclerViewPop.setAdapter(new MoviePopAdapter(this.getContext(), moviePopList));

        moviePopList.add(new MovieCard("Solo Leveling", "Lorem ipsum blablabla", getActivity().getDrawable(R.drawable.card_1)));
        moviePopList.add(new MovieCard("Attack on Titan", "Lorem ipsum blablabla", getActivity().getDrawable(R.drawable.card_2)));
        moviePopList.add(new MovieCard("Jujutsu Kaisen", "Lorem ipsum blebleble", getActivity().getDrawable(R.drawable.card_3)));
        moviePopList.add(new MovieCard("Demon Slayer", "Lorem ipsum blablabla", getActivity().getDrawable(R.drawable.card_4)));
        moviePopList.add(new MovieCard("One Piece", "Lorem ipsum blablabla", getActivity().getDrawable(R.drawable.card_5)));
        moviePopList.add(new MovieCard("Solo Leveling", "Lorem ipsum blablabla", getActivity().getDrawable(R.drawable.card_1)));
        moviePopList.add(new MovieCard("Attack on Titan", "Lorem ipsum blablabla", getActivity().getDrawable(R.drawable.card_2)));
        moviePopList.add(new MovieCard("Jujutsu Kaisen", "Lorem ipsum blebleble", getActivity().getDrawable(R.drawable.card_3)));
        moviePopList.add(new MovieCard("Demon Slayer", "Lorem ipsum blablabla", getActivity().getDrawable(R.drawable.card_4)));
        moviePopList.add(new MovieCard("One Piece", "Lorem ipsum blablabla", getActivity().getDrawable(R.drawable.card_5)));

        return view;
    }
}