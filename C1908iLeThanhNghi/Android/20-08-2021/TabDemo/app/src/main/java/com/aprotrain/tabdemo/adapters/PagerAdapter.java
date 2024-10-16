package com.aprotrain.tabdemo.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.aprotrain.tabdemo.fragments.FragmentOne;
import com.aprotrain.tabdemo.fragments.FragmentThree;
import com.aprotrain.tabdemo.fragments.FragmentTwo;

import java.util.ArrayList;
import java.util.List;

public class PagerAdapter extends FragmentStateAdapter {
    private List<Fragment> fragments = new ArrayList<>();
    public PagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        fragments.add(FragmentOne.getInstance());
        fragments.add(FragmentTwo.getInstance());
        fragments.add(FragmentThree.getInstance());
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }
    @Override
    public int getItemCount() {
        return fragments.size();
    }
}
