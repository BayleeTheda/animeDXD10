package com.kelompok10.animedxd10;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import android.view.inputmethod.InputMethodManager;
import android.content.Context;

import androidx.fragment.app.Fragment;

public class DetailPageFragment extends Fragment {

    private RelativeLayout reviewPopup;
    private EditText etReview;
    private TextView tvError, tvTitle, tvGenre, tvSynopsis;
    private ImageView imgCover;

    public DetailPageFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_page, container, false);

        ImageButton btnBack = view.findViewById(R.id.btnBack);
        Button btnReview = view.findViewById(R.id.btnReview);
        Button btnSubmitReview = view.findViewById(R.id.btnSubmitReview);
        reviewPopup = view.findViewById(R.id.reviewPopup);
        etReview = view.findViewById(R.id.etReview);
        tvError = view.findViewById(R.id.tvError);
        tvTitle = view.findViewById(R.id.tvTitle);
        tvGenre = view.findViewById(R.id.tvGenre);
        tvSynopsis = view.findViewById(R.id.tvSynopsis);
        imgCover = view.findViewById(R.id.imgCover);

         LinearLayout popupContainer = view.findViewById(R.id.popupContainer);

        // Ambil data dari bundle
        if (getArguments() != null) {
            tvTitle.setText(getArguments().getString("title"));
            tvGenre.setText(getArguments().getString("genre"));
            tvSynopsis.setText(getArguments().getString("synopsis"));
            imgCover.setImageResource(getArguments().getInt("image"));
        }

        // Back button click
        btnBack.setOnClickListener(v -> requireActivity().onBackPressed());

        // Open review popup
        btnReview.setOnClickListener(v -> {
            reviewPopup.setVisibility(View.VISIBLE);
            btnReview.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_dark));

            etReview.requestFocus();
            InputMethodManager imm = (InputMethodManager) requireContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(etReview, InputMethodManager.SHOW_IMPLICIT);
        });

        // Submit review
        btnSubmitReview.setOnClickListener(v -> {
            btnSubmitReview.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_dark));

            String reviewText = etReview.getText().toString().trim();
            if (reviewText.isEmpty()) {
                tvError.setVisibility(View.VISIBLE);
            } else {
                tvError.setVisibility(View.GONE);
                reviewPopup.setVisibility(View.GONE);
                etReview.setText("");
                Toast.makeText(getContext(), "Review berhasil dikirim!", Toast.LENGTH_SHORT).show();

                btnSubmitReview.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
                btnReview.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
            }
        });

        // Close popup if user clicks outside
        reviewPopup.setOnClickListener(v -> reviewPopup.setVisibility(View.GONE));

         Button btnCancel = view.findViewById(R.id.btnCancel);
         btnCancel.setOnClickListener(v -> reviewPopup.setVisibility(View.GONE));

        return view;
    }
}
