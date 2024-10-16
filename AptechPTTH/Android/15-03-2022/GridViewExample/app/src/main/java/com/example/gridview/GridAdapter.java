package com.example.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.gridview.models.Person;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter{
    Context context;
//    String[] personName;
//    int[] image;
    private ArrayList<Person> persons;//encapsulation

    public GridAdapter(Context context, ArrayList<Person> persons) {
        this.context = context;
//        this.personName = personName;
//        this.image = image;
        this.persons = persons;
    }

    @Override
    public int getCount() {
        return persons.size();
    }

    @Override
    public Object getItem(int i) {
        return persons.get(i);
    }

    @Override
    public long getItemId(int i) {
        //each object has 1 unique ID(1NF)
        return persons.get(i).hashCode();
}

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        convertView = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                        .inflate(R.layout.grid_item,null);
        Person selectedPerson = persons.get(position);
        ImageView imageView = convertView.findViewById(R.id.grid_image);
        TextView textView = convertView.findViewById(R.id.itemname);
        imageView.setImageResource(selectedPerson.getImageId());
        textView.setText(selectedPerson.getName());
        return convertView;
    }
}
