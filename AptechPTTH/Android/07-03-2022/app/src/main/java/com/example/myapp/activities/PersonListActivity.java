package com.example.myapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.myapp.R;
import com.example.myapp.adapters.PersonsAdapter;
import com.example.myapp.models.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonListActivity extends AppCompatActivity {
    private ListView listViewPersons;
    private List<Person> persons = new ArrayList<Person>();
    private PersonsAdapter personsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_list_activity);
        listViewPersons = findViewById(R.id.listViewPersons);
        //fake list
        persons.add(new Person(1, "John", "ddsa@gmail.com", "1133233322"));
        persons.add(new Person(2, "mdnsjhdns", "ddsa@gmail.com", "65465662655"));
        persons.add(new Person(3, "dsds", "ddsa@gmail.com", "6565656"));
        persons.add(new Person(4, "ee", "ddsa@gmail.com", "144874415444"));
        persons.add(new Person(5, "Jeweohn", "ddsa@gmail.com", "1545444515"));
        persons.add(new Person(6, "Joeehn", "ddsa@gmail.com", "9898979299"));
        persons.add(new Person(7, "Joeehn", "ddsa@gmail.com", "9529299211"));
        persons.add(new Person(8, "Joettqwhn", "ddsa@gmail.com", "59021184848"));
        //objects(data) => Adapter => ListView(UI)
        personsAdapter = new PersonsAdapter(persons);
        listViewPersons.setAdapter(personsAdapter);
    }
}