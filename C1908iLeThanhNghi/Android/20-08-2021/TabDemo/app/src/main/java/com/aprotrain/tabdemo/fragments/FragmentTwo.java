package com.aprotrain.tabdemo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.aprotrain.tabdemo.R;

public class FragmentTwo extends Fragment {
    private FragmentTwo() {
        super();
    }
    //singleton object
    private static FragmentTwo instance;
    public static FragmentTwo getInstance() {
        if(instance == null) {
            instance = new FragmentTwo();
        }
        return instance;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //findViewById
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        return view;
    }
}
