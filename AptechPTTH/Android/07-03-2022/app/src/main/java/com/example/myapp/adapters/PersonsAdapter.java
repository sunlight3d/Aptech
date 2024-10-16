package com.example.myapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapp.R;
import com.example.myapp.models.Person;

import java.util.List;

public class PersonsAdapter extends BaseAdapter {
    //ham khoi tao
    private List<Person> persons;
    public PersonsAdapter(List<Person> persons){
        super();//call parent's method
        this.persons = persons;
    }

    @Override
    public int getCount() {
        //how many list's item ?
        return persons.size();
    }

    @Override
    public Object getItem(int i) {
        return persons.get(i);//i = 0, 1, 2, 3, ...
    }
    @Override
    public long getItemId(int i) {
        //where is "primary key"/"key" ?
        //return persons.get(i).hashCode();
        return persons.get(i).getPersonId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //How is the item's UI ?
        //get from xml file
        //findViewById
        view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.person_list_item, viewGroup, false);
        TextView textView1 = view.findViewById(R.id.textView1);
        textView1.setText("kaka");
        return view;
    }
}
