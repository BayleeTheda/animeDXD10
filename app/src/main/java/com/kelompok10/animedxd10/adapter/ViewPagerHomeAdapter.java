package com.kelompok10.animedxd10.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.kelompok10.animedxd10.MangaFragment;
import com.kelompok10.animedxd10.NewsFragment;

public class ViewPagerHomeAdapter extends FragmentStateAdapter {
    public ViewPagerHomeAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position == 0){
            return new NewsFragment();
        }else{
            return new MangaFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
