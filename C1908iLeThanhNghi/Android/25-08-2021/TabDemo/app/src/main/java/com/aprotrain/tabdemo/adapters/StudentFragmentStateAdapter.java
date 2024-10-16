package com.aprotrain.tabdemo.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.aprotrain.tabdemo.fragments.StudentPageFragment;
import com.aprotrain.tabdemo.models.Student;

import java.util.List;

public class StudentFragmentStateAdapter extends FragmentStateAdapter {
    //Adapter : from Data to Fragments

    private List<Student> students;

    public StudentFragmentStateAdapter(@NonNull FragmentActivity fragmentActivity, List<Student> students) {
        super(fragmentActivity);
        this.students = students;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Student student = this.students.get(position);
        return new StudentPageFragment(student);
    }

    @Override
    public int getItemCount() {
        return students.size();
    }
}
