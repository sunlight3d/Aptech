package com.aptech;

import com.aptech.models.Artist;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) {
        AlbumManagement albumManagement = new AlbumManagement();
        albumManagement.initiateAlbumnList();
        System.out.println("min view count: ");
        System.out.println(albumManagement.getMinViewCount().toString());
        System.out.println("max view count: ");
        System.out.println(albumManagement.getMaxViewCount().toString());
//        Locale locale_it_vn = new Locale("vi_VN", "VN");
//        Locale locale_ru_en = new Locale("en-US", "US");
        ResourceBundle bundleEN = ResourceBundle.getBundle("en", Locale.ENGLISH);
        //Get ResourceBundle with Locale that are already defined
        ResourceBundle bundleVN = ResourceBundle.getBundle("vn");
        System.out.println(bundleVN.getString("name"));
        //Tham khao them o day:
        //https://github.com/nirm2009/lokalise/blob/master/java-i18n/src/Main.java


    }
}