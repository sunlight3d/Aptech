import org.aptech.javade02.SavingsAccount;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestSavingsAccount {
    @Test
    public void testSavings() {
        //String message, Object expected, Object actual
        SavingsAccount saver1 = new SavingsAccount(2000.0);
        SavingsAccount saver2 = new SavingsAccount(3000.0);
        SavingsAccount.modifyInterestRate(0.04f);
        Double x1 = saver1.calculateMonthlyInterest(); //6.6666

        Double x2 = saver2.calculateMonthlyInterest();
        //9.9999
        Double y1 = saver1.getBalance(); //2006.6666
        Double y2 = saver2.getBalance();//3009.9999
        assertTrue("interest not the same1",
                6.6666 - Math.floor(x1 * 10000)/10000 == 0);
        assertTrue("interest not the same2",
                9.9999 - Math.floor(x2 * 10000)/10000 == 0);

        assertTrue("balance not the same1",
                2006.6666 - Math.floor(y1 * 10000)/10000 == 0);
        assertTrue("balance not the same1",
                3009.9999 - Math.floor(y2 * 10000)/10000 == 0);
    }
}
