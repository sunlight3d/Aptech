package com.aprotrain.calculatorapp;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;

import com.aprotrain.calculatorapp.models.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText txtExpression;
    private TableLayout tableLayout;
    private List<List<Item>> getButtons() {
         List<List<Item>> result = new ArrayList<>();
         result.add(Arrays.asList(new Item[] {
                 new Item("%", false), new Item("CE", false),
                 new Item("C", false), new Item("<", false)}));


        result.add(Arrays.asList(new Item[] {
                new Item("1/x", false), new Item("x2", false),
                new Item("√", false), new Item("÷", false)}));

        result.add(Arrays.asList(new Item[] {
                new Item("7", true), new Item("8", true),
                new Item("9", true), new Item("×", false)}));

        result.add(Arrays.asList(new Item[] {
                new Item("4", true), new Item("5", true),
                new Item("6", true), new Item("-", false)}));

        result.add(Arrays.asList(new Item[] {
                new Item("1", true), new Item("2", true),
                new Item("3", true), new Item("+", false)}));

        result.add(Arrays.asList(new Item[] {
                new Item("1/x", false), new Item("x2", false),
                new Item("sqX", false), new Item("/", false)}));

        result.add(Arrays.asList(new Item[] {
                new Item("%", false), new Item("CE", false),
                new Item("C", false), new Item("<", false)}));

        result.add(Arrays.asList(new Item[] {
                new Item("±", false), new Item("0", false),
                new Item(".", false), new Item("-", false)}));

         return result;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //layout programmatically
        tableLayout = findViewById(R.id.tableLayout);
        List<List<Item>> buttons = getButtons();
        for(List<Item> row: buttons) {
            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new TableRow.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
            for(Item item: row) {
                Button button = new Button(this);
                button.setHeight(130);
                button.setBackgroundColor(0x000000);
                button.setText(item.getContent());
                button.setTextSize(22);//sp
                button.setTextColor(Color.parseColor("#FFFFFF"));
                button.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
                tableRow.addView(button);
                button.setOnClickListener((View v) ->{
                    if(!item.isShow()) {
                        return;
                    }
                    String currentExpression = txtExpression.getText().toString();
                    txtExpression.setText(String.format("%s%s", currentExpression,item.getContent()));
                });
            }
            tableLayout.addView(tableRow, new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT));
        }
        txtExpression = findViewById(R.id.txtExpression);
    }
}