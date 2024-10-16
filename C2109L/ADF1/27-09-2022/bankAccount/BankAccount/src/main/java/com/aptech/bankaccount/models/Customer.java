package com.aptech.bankaccount.models;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Customer {
    private long customerId;
    private String fullName;
    private ArrayList<Account> accountList = new ArrayList<>();

    public Customer() {

    }

    public Customer(long customerId, String fullName) {
        this.customerId = customerId;
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return  "fullname: "    +fullName+","
                +"customerId: " +customerId;
    }
    public void addAccount(Account account) {
        //customer must have 1 Checking account, and many SavingsAccount
        if((!hasCheckingAccount() && account instanceof CheckingAccount)
                || account instanceof SavingsAccount) {
            this.accountList.add(account);
        }
    }
    private boolean hasCheckingAccount() {
        return this.accountList
                .stream()
                .filter((Account eachAccount) -> eachAccount instanceof CheckingAccount)
                .toList().size() > 0;
    }

    public void removeAccount(Account account) {
        //customer must have AT LEAST 1 checking Account
        if(this.accountList
                .stream()
                .filter((Account eachAccount) ->
                        eachAccount instanceof CheckingAccount
                                && eachAccount.equals(account))
                .toList().size() > 0) {
            System.err.println("Cannot delete your checking account");
        } else {
            this.accountList
                    .removeIf((Account eachAccount) -> eachAccount.equals(account));
        }
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public ArrayList<Account> getAccountList() {
        return accountList;
    }

}
