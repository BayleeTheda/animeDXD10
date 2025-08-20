package com.kelompok10.animedxd10;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AboutFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AboutFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private String username;
    private TextView usernameText;

    public AboutFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AboutFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AboutFragment newInstance(String param1, String param2) {
        AboutFragment fragment = new AboutFragment();
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
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        usernameText = view.findViewById(R.id.username);
        usernameText.setText("Welcome, " + username);


        TextView about_desc = view.findViewById(R.id.about_desc);
        about_desc.setText("AnimeDXD is a digital company focused on entertainment, especially in providing anime and manga content. Founded with the spirit of delivering the best experience for anime fans, AnimeDXD offers a modern, user-friendly platform with rich features.\n" +
                "\n" +
                "Recognizing the growing global interest in anime, AnimeDXD is committed to delivering a complete service, from anime catalogs and the latest news to detailed information about popular titles. The application is designed so users can enjoy entertainment quickly, conveniently, and in an organized way.\n" +
                "\n" +
                "As a startup, AnimeDXD emphasizes technological innovation and user satisfaction. With a mission to strengthen the global anime community, AnimeDXD aims to become the leading platform that brings together watching, reading, and exploring the world of anime in one place.");

        return view;
    }
}