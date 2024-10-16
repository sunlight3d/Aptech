package com.aptech.bankaccount.models;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bank {
    private String bankName;
    private ArrayList<Customer> customerList = new ArrayList<>();
    public Bank(String bankName) {
        this.bankName = bankName;
    }
    public void readCustomerList(InputStream inputStream) throws IOException{
        BufferedReader bufferedReader
                = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
            String patternString = "^[\\sa-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễếệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]*";
            Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(line);
            String name = "";
            while(matcher.find()){
                name = matcher.group(0);
            }
            line = line.replaceAll(name, "");
            String[] lines = line.split(" ");
            long Idcard = Long.valueOf(lines[0]);
            long accountNumber = Long.valueOf(lines[1]);
            String accountType = lines[2].toLowerCase();
            long balance = Double.valueOf(lines[3]).longValue();
            if(lines.length >= 5) {
                long accountNumberSavings = Long.valueOf(lines[4]);
                String accountTypeSavings = lines[5].toLowerCase();
                long balanceSavings = Double.valueOf(lines[6]).longValue();
            }
        }
    }
}
