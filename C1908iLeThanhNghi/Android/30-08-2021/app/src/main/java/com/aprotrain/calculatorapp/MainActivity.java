package com.aprotrain.calculatorapp;
import android.graphics.Color;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<List<String>> getButtons() {
         List<List<String>> result = new ArrayList<>();
         result.add(Arrays.asList(new String[] {"%", "CE", "C", "<"}));
         result.add(Arrays.asList(new String[] {"1/x", "x2", "√", "÷"}));
         result.add(Arrays.asList(new String[] {"7", "8", "9", "×"}));
         result.add(Arrays.asList(new String[] {"4", "5", "6", "-"}));
         result.add(Arrays.asList(new String[] {"1", "2", "3", "+"}));
         result.add(Arrays.asList(new String[] {"1/x", "x2", "sqX", "/"}));
         result.add(Arrays.asList(new String[] {"±", "0", ".", "="}));
         return result;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //layout programmatically
        TableLayout tableLayout = findViewById(R.id.tableLayout);
        List<List<String>> buttons = getButtons();
        for(List<String> row: buttons) {
            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new TableRow.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
            tableRow.setBackgroundColor(0xff0000);
            for(String item: row) {
                Button button = new Button(this);
                //button.setBackgroundColor(0x1f1f1f);
                button.setText(item);
                button.setTextColor(Color.parseColor("#ff0000"));
                button.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
                tableRow.addView(button);
            }
            tableLayout.addView(tableRow, new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT));
        }


    }
}