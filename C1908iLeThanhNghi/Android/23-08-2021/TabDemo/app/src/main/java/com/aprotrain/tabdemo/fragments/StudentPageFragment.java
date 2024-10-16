package com.aprotrain.tabdemo.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.aprotrain.tabdemo.R;
import com.aprotrain.tabdemo.models.Student;
import com.squareup.picasso.Picasso;

public class StudentPageFragment extends Fragment {
    private Student student;
    private ImageView imageView;
    private TextView txtFullName;
    private TextView txtTelephone;
    private TextView txtEmail;
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
        txtFullName =  view.findViewById(R.id.txtFullName);
        txtTelephone =  view.findViewById(R.id.txtTelephone);
        txtEmail =  view.findViewById(R.id.txtEmail);
        imageView = view.findViewById(R.id.imageView);

        txtFullName.setText(String.format("Fullname: %s", student.getFullName()));
        txtTelephone.setText(String.format("Phone: %s", student.getPhoneNumber()));
        txtEmail.setText(String.format("Email: %s", student.getEmail()));
        //view.setBackgroundColor(Color.parseColor("#ebdef0"));
        Picasso.get().load(student.getUrl()).into(imageView);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //send params
        super.onViewCreated(view, savedInstanceState);
    }

}
