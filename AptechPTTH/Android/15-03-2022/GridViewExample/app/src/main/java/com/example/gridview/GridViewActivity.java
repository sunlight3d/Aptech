package com.example.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.gridview.databinding.GridviewActivityBinding;
import com.example.gridview.models.Person;

import java.util.ArrayList;

public class GridViewActivity extends AppCompatActivity {

    //private GridviewActivityBinding binding;
    private ArrayList<Person> persons = new ArrayList<Person>();
    private GridAdapter gridAdapter;
    private GridView gridView;

    //fake persons / get from web service
    private void getPersons() {
        persons.add(new Person("Tranh", R.drawable.tranh1)) ;
        persons.add(new Person("Tranh tranh", R.drawable.tranh2)) ;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview_activity);
        gridView = findViewById(R.id.gridView);
        //binding = GridviewActivityBinding.inflate(getLayoutInflater());
        //setContentView(binding.getRoot());
        //String[] personName = {"Tranh","Tranh tranh"};
        //int[] personImage = {R.drawable.tranh1,R.drawable.tranh2}; //person object => model(Person)
        //if we have 10 fields => so complicated!
        //compose to objects
        //array can be add/remove => ArrayList

        //GridAdapter gridAdapter = new GridAdapter(GridViewActivity.this,personName,personImage);
        getPersons();
        gridAdapter = gridAdapter == null ? new GridAdapter(this, persons) : gridAdapter;
        gridView.setAdapter(gridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,View view,int position,long id) {
                Person selectedPerson = persons.get(position);
                String message = String.format("You click on %s", selectedPerson.getName());
                Toast.makeText(GridViewActivity.this,message,Toast.LENGTH_SHORT).show();
            }
        });
    }
}