package excercise1;

import java.util.ArrayList;
import java.util.Scanner;

public class TransactionController {
    ArrayList<Transaction>  transactions = new ArrayList<Transaction>();
    public void inputTransactions() {
        int numberOfHouseTransactions;
        int numberOfLandTransactions;
        System.out.println("Enter number of house transactions: ");
        numberOfHouseTransactions = (new Scanner(System.in)).nextInt();
        for(int i = 0; i < numberOfHouseTransactions; i++) {
            HouseTransaction houseTransaction = new HouseTransaction();
            houseTransaction.input();
            transactions.add(houseTransaction);
        }
        System.out.println("Enter number of land transactions: ");
        numberOfLandTransactions = (new Scanner(System.in)).nextInt();
        for(int i = 0; i < numberOfLandTransactions; i++) {
            LandTransaction landTransaction = new LandTransaction();
            landTransaction.input();
            transactions.add(landTransaction);
        }

    }
    public void calculateAmounts() {
        //muon tinh manual
        int numberOfHouseTransactions = 0;
        int numberOfLandTransactions = 0;
        //Dem co bao nhieu loai dat A
        int numberOfTypA = 0;
        int numberOfTypB = 0;
        int numberOfVip = 0;
        int numberOfNormal = 0;
        for(Transaction transaction: transactions) {
            if(transaction instanceof HouseTransaction) {
                numberOfHouseTransactions ++;
                if(((HouseTransaction) transaction).getHouseType() == HouseType.NORMAL) {
                    numberOfNormal++;
                } else if(((HouseTransaction) transaction).getHouseType() == HouseType.VIP) {
                    numberOfVip++;
                }

            }else if(transaction instanceof LandTransaction) {
                numberOfLandTransactions ++;
                if(((LandTransaction) transaction).getLandType() == LandType.A) {
                    numberOfTypA ++;
                } else if(((LandTransaction) transaction).getLandType() == LandType.B) {
                    numberOfTypB++;
                }
            }
        }
        System.out.println("numberOfHouseTransactions = "+numberOfHouseTransactions);
        System.out.println("numberOfLandTransactions = "+numberOfLandTransactions);


    }
}
