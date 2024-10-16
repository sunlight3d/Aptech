package com.aptech;

import com.aptech.models.Opportunity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.aptech.Helper.getBufferReader;

public class Main {
    public static void main(String[] args) {
        List<Opportunity> opportunities = new ArrayList<Opportunity>();
        for(int i = 0; i < 5; i++) {
            System.out.println("Enter information : "+(i+1));
            Opportunity opportunity = new Opportunity();
            opportunity.input();
            opportunities.add(opportunity);
            //Phần lưu file các bạn xem bài ngày 08-11
        }
    }
}