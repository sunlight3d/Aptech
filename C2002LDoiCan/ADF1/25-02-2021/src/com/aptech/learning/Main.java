package com.aptech.learning;

import com.aptech.learning.models.BankAccount;

public class Main {

    public static void main(String[] args) {
        BankAccount accountMrHoang = new BankAccount(
                1231_4562_7891_3332L,
                "Nguyen Duc Hoang");
        accountMrHoang.addCash(10.0);
        System.out.println(accountMrHoang.getBalance());
        accountMrHoang.withdraw(5.0, 1.0);
        System.out.println(accountMrHoang.getBalance());
        BankAccount accountMrA = new BankAccount(
                3333_4562_7891_3332L,
                "Nguyen Van A");
        accountMrHoang.transferMoney(accountMrA, 5.0);
        System.out.println(accountMrHoang.getBalance());
        System.out.println(accountMrA.getBalance());
    }
}
