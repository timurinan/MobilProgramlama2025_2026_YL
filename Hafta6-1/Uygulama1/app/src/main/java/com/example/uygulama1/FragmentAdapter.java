package com.example.uygulama1;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class FragmentAdapter extends FragmentStateAdapter {

    ArrayList<HesapFragment> hesapfragments=new ArrayList<HesapFragment>();

    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return hesapfragments.get(position);
    }

    @Override
    public int getItemCount() {
        return hesapfragments.size();
    }

    public void addFragment(HesapFragment hf){
        hesapfragments.add(hf);
    }
}
