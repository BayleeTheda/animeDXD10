package com.kelompok10.animedxd10;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.google.android.flexbox.FlexboxLayout;

import androidx.fragment.app.Fragment;

public class DetailPageFragment extends Fragment {
    private TextView tvTitle, tvGenre, tvSynopsis;
    private ImageView imgCover;

    public DetailPageFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_page, container, false);

        TextView tvTitle = view.findViewById(R.id.tvTitle);
        TextView tvSynopsis = view.findViewById(R.id.tvSynopsis);
        ImageView imgCover = view.findViewById(R.id.imgCover);
        FlexboxLayout layoutGenres = view.findViewById(R.id.layoutGenres);

        ImageButton btnBack = view.findViewById(R.id.btnBack);
        Button btnReview = view.findViewById(R.id.btnReview);

        btnBack.setOnClickListener(v -> {
            requireActivity().getSupportFragmentManager().popBackStack();
        });


        btnReview.setOnClickListener(v -> {
            PopupReviewFragment popup = new PopupReviewFragment();
            popup.show(requireActivity().getSupportFragmentManager(), "PopupReview");
        });


        if (getArguments() != null) {
            tvTitle.setText(getArguments().getString("title"));
            tvSynopsis.setText(getArguments().getString("synopsis"));
            imgCover.setImageResource(getArguments().getInt("image"));

            String genreStr = getArguments().getString("genre");
            if (genreStr != null) {
                String[] genres = genreStr.split(",\\s*");
                for (String g : genres) {
                    TextView chip = new TextView(getContext());
                    chip.setText(g);
                    chip.setTextSize(12);
                    chip.setTextColor(getResources().getColor(android.R.color.white));
                    chip.setBackgroundResource(R.drawable.bg_genre_gray);
                    chip.setPadding(16, 8, 16, 8);

                    chip.setTextColor(getResources().getColor(android.R.color.black));//
                    if (g.equalsIgnoreCase("General List Top 1") ||
                            g.equalsIgnoreCase("Comic Adaptation")) {
                        chip.setTextColor(getResources().getColor(android.R.color.white));
                    }

                    FlexboxLayout.LayoutParams params =
                            new FlexboxLayout.LayoutParams(
                                    ViewGroup.LayoutParams.WRAP_CONTENT,
                                    ViewGroup.LayoutParams.WRAP_CONTENT);
                    params.setMargins(8, 8, 8, 8);

                    chip.setLayoutParams(params);
                    layoutGenres.addView(chip);
                }
            }
        }

        return view;
    }
}
