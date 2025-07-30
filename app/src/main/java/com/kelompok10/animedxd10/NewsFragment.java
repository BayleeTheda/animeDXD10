package com.kelompok10.animedxd10;

import android.content.Intent;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.kelompok10.animedxd10.adapter.MovieAdapter;
import com.kelompok10.animedxd10.model.MovieCard;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private String username;
    private TextView usernameText;

    private List<MovieCard> movieRecomList = new ArrayList<>();
    private RecyclerView recyclerViewRecom;

    public NewsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewsFragment newInstance(String param1, String param2) {
        NewsFragment fragment = new NewsFragment();
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

        Intent intent = getActivity().getIntent();
        username = intent.getStringExtra("username");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        usernameText = view.findViewById(R.id.username);
        usernameText.setText("Welcome, " + username);
        ImageSlider imageSlider = view.findViewById(R.id.banner);
        ArrayList<SlideModel> slideBanner = new ArrayList<>();

        slideBanner.add(new SlideModel(R.drawable.banner_1, ScaleTypes.FIT));
        slideBanner.add(new SlideModel(R.drawable.banner_2, ScaleTypes.FIT));
        slideBanner.add(new SlideModel(R.drawable.banner_3, ScaleTypes.FIT));
        slideBanner.add(new SlideModel(R.drawable.banner_4, ScaleTypes.FIT));
        slideBanner.add(new SlideModel(R.drawable.banner_5, ScaleTypes.FIT));

        imageSlider.setImageList(slideBanner, ScaleTypes.CENTER_CROP);

        recyclerViewRecom = view.findViewById(R.id.recyclerRecom);
        recyclerViewRecom.setHasFixedSize(true);
        recyclerViewRecom.setLayoutManager(new LinearLayoutManager(this.getContext(), RecyclerView.HORIZONTAL, false));
        recyclerViewRecom.setAdapter(new MovieAdapter(getContext(), movieRecomList));

        movieRecomList.add(new MovieCard("Solo Leveling", "Lorem ipsum blablabla", getActivity().getDrawable(R.drawable.card_1)));
        movieRecomList.add(new MovieCard("Attack on Titan", "Lorem ipsum blablabla", getActivity().getDrawable(R.drawable.card_2)));
        movieRecomList.add(new MovieCard("Jujutsu Kaisen", "Lorem ipsum blebleble", getActivity().getDrawable(R.drawable.card_3)));

        return view;
    }
}