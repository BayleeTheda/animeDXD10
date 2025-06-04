package com.kelompok10.animedxd10;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle("");
        actionBar.setIcon(R.drawable.home_24dp_e3e3e3_fill0_wght400_grad0_opsz24);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        Fragment MovieFragment = new MovieFragment();
        Fragment HomeFragment = new HomeFragment();
        Fragment AboutFragment = new AboutFragment();

        setCurrentFragment(HomeFragment);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            if(item.getItemId() == R.id.movie){
                setCurrentFragment(MovieFragment);
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

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(item.getItemId() == R.id.menuDropdown){
            Toast.makeText(this, "Menu dropdown clicked", Toast.LENGTH_SHORT).show();
            return super.onOptionsItemSelected(item);
        }
        return true;
    }

    private void setCurrentFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, fragment).commit();
    }
}