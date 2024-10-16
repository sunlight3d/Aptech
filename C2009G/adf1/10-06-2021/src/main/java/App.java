import excercise1.Transaction;
import excercise1.TransactionController;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello");
        TransactionController transactionController = new TransactionController();
        transactionController.inputTransactions();
        transactionController.calculateAmounts();
    }
}
