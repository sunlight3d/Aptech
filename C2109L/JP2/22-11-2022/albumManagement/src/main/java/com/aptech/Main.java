package com.aptech;

import com.aptech.models.Artist;
import lombok.extern.log4j.Log4j2;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        AlbumManagement albumManagement = new AlbumManagement();
        albumManagement.initiateAlbumnList();
        System.out.println("min view count: ");
        System.out.println(albumManagement.getMinViewCount().toString());
        System.out.println("max view count: ");
        System.out.println(albumManagement.getMaxViewCount().toString());
        //Tham khao them o day:
        //https://github.com/nirm2009/lokalise/blob/master/java-i18n/src/Main.java

        Locale locale_vn_VN = new Locale("vn", "VN");
        Locale locale_en_EN = new Locale("en", "EN");

        ResourceBundle resourceBundleVN = ResourceBundle.getBundle("bundle", locale_vn_VN);
        ResourceBundle resourceBundleEN = ResourceBundle.getBundle("bundle", locale_en_EN);
        String name = "Ho Van Cuong";
        String dob = "20-11-1991";
        double fee = 2000;
        System.out.println("English");
        System.out.println(resourceBundleEN.getString("name")+" " + name);
        System.out.println(resourceBundleEN.getString("dob")+" "
                + Helper.getDateString(dob, Locale.ENGLISH));
        System.out.println(resourceBundleEN.getString("fee")+" " + fee);

        System.out.println("Vietnamese");
        System.out.println(resourceBundleVN.getString("name")+ " " + name);
        System.out.println(resourceBundleEN.getString("dob")+" "
                + Helper.getDateString(dob, new Locale("vi", "VN")));
        System.out.println(resourceBundleVN.getString("fee")+ " " + fee);


    }
}