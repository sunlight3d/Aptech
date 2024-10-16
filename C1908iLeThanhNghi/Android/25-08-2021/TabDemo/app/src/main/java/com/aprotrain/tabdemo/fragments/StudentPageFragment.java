package com.aprotrain.tabdemo.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.aprotrain.tabdemo.R;
import com.aprotrain.tabdemo.models.Student;

public class StudentPageFragment extends Fragment {
    private Student student;
    private TextView txtFullName;
    public StudentPageFragment(Student student) {
        this.student = student;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  (ViewGroup) inflater.inflate(
                R.layout.student_fragment, container, false);
        //map data to UI
        TextView txtFullName =  view.findViewById(R.id.txtFullName);
        txtFullName.setText(student.getFullName());
        //view.setBackgroundColor(Color.parseColor("#ebdef0"));
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //send params
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
