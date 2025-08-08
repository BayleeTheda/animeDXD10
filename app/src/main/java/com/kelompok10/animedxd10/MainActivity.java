package com.kelompok10.animedxd10;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.kelompok10.animedxd10.AnimeListFragment;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kelompok10.animedxd10.adapter.MovieAdapter;
import com.kelompok10.animedxd10.model.MovieCard;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView profile_dropdown = findViewById(R.id.profile_dropdown);
        RelativeLayout profile_dropdown_expand = findViewById(R.id.profile_dropdown_expand);

        profile_dropdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(profile_dropdown_expand.getVisibility() == GONE){
                    profile_dropdown_expand.setVisibility(VISIBLE);
                }else{
                    profile_dropdown_expand.setVisibility(GONE);
                }
            }
        });

        Intent intent = getIntent();

        TextView profile_name = findViewById(R.id.profile_name);
        profile_name.setText(intent.getStringExtra("username"));

        CardView logout_btn = findViewById(R.id.logout_btn);
        logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        Fragment AnimeListFragment = new AnimeListFragment();
        Fragment HomeFragment = new HomeFragment();
        Fragment AboutFragment = new AboutFragment();

        setCurrentFragment(HomeFragment);
        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            if(item.getItemId() == R.id.movie){
                setCurrentFragment(AnimeListFragment);
                return true;
            }else if(item.getItemId() == R.id.home){
                setCurrentFragment(HomeFragment);
                return true;
            }else if(item.getItemId() == R.id.info){
                setCurrentFragment(AboutFragment);
                return true;
            }
            return true;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void setCurrentFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, fragment).commit();
    }
}