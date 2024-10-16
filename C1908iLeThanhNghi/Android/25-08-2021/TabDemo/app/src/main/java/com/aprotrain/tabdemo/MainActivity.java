package com.aprotrain.tabdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.aprotrain.tabdemo.adapters.StudentFragmentStateAdapter;
import com.aprotrain.tabdemo.models.Student;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        viewPager2 = this.findViewById(R.id.viewPager2);
        StudentFragmentStateAdapter adapter = new StudentFragmentStateAdapter(this, getFakeStudents());
        viewPager2.setAdapter(adapter);
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        new TabLayoutMediator(tabLayout, viewPager2,
                (tab, position) -> tab.setText("page " + (position + 1))
        ).attach();
    }
    private List<Student> getFakeStudents() {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(1,"Nguyen Van A","nva@gmai.com", "", "1111111"));
        students.add(new Student(2,"Nguyen Van B","nva@gmai.com", "", "1111111"));
        students.add(new Student(3,"Nguyen Van C","nva@gmai.com", "", "1111111"));
        students.add(new Student(4,"Nguyen Van D","nva@gmai.com", "", "1111111"));
        return students;
    }
}