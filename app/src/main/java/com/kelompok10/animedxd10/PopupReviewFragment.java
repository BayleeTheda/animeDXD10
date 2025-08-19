package com.example.yourapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class PopupReviewFragment extends DialogFragment {

    private EditText etReview;
    private TextView tvError;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_popup_review, container, false);

        etReview = view.findViewById(R.id.etReview);
        tvError = view.findViewById(R.id.tvError);
        Button btnSubmit = view.findViewById(R.id.btnSubmit);
        ImageButton btnClose = view.findViewById(R.id.btnClose);

        // Tutup popup jika klik tombol X
        btnClose.setOnClickListener(v -> dismiss());

        // Validasi Submit
        btnSubmit.setOnClickListener(v -> {
            String reviewText = etReview.getText().toString().trim();
            if (TextUtils.isEmpty(reviewText)) {
                tvError.setVisibility(View.VISIBLE);
            } else {
                tvError.setVisibility(View.GONE);
                // TODO: Kirim data review ke server / simpan ke database
                dismiss();
            }
        });

        // Tutup popup jika user klik di luar area (background abu2)
        view.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                int[] location = new int[2];
                View popup = view.findViewById(R.id.etReview).getRootView();
                popup.getLocationOnScreen(location);
                dismiss();
            }
            return false;
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        // Biar popup memenuhi layar penuh (supaya area luar bisa di-klik untuk dismiss)
        if (getDialog() != null && getDialog().getWindow() != null) {
            getDialog().getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
            getDialog().getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        }
    }
}
