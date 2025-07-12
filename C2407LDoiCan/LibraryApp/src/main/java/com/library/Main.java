package com.library;

import com.library.system.LiteratureManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        LiteratureManager literatureManager = new LiteratureManager();
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        int choice = 0;

        while (choice != 4) {
            System.out.println("=== MENU QUẢN LÝ VĂN HỌC ===\n" +
                    "1. Thêm tác phẩm\n" +
                    "2. Hiển thị tất cả tác phẩm\n" +
                    "3. Tìm tác phẩm dài nhất\n" +
                    "4. Thoát\n" +
                    "Lựa chọn của bạn:\n");
            try {
                choice = Integer.parseInt(reader.readLine());
                if(choice == 1) {
                    literatureManager.addWord();
                }else if(choice == 2) {
                    literatureManager.showAllWorks();
                }else if(choice == 3) {
                    literatureManager.findLongestWork();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
