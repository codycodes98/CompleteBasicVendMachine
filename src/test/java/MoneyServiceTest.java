import com.main.MoneyService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MoneyServiceTest {
    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    MoneyService moneyService;
    @Before
    public void setUp(){
        moneyService = new MoneyService();
        System.setOut(new PrintStream(output));
    }

//    @Test
//    public void shouldIncreaseBalance() {
//        double balance = moneyService.addBalance(5.00, 0.00);
//        assertEquals(balance, 5.00, 0.00);
//
//    }
//    @Test
//    public void shouldDecreaseBalance() {
//        double balance = moneyService.decreaseBalance(2.00, 5.00);
//        assertEquals(balance, 3.00, 0.00);
//    }
    @Test
    public void shouldReturnTrueIfSufficientMoney(){
        double itemPrice = 1;
        double currentBalance = 2;
        assertTrue(moneyService.hasSufficientFunds(currentBalance, itemPrice));

    }
    @Test
    public void shouldReturnFalseIfInsufficientFunds(){
        double itemPrice = 1;
        double currentBalance = 0.9;
        assertFalse(moneyService.hasSufficientFunds(currentBalance, itemPrice));
    }
    @Test
    public void shouldDispenseChangeIfRequired() {
        double itemPrice = 1;
        double currentBalance = 2;
        moneyService.dispenseChange(currentBalance, itemPrice);
        assertEquals(output.toString(), "Please take your change £1.00\n");
    }

    @Test
    public void shouldGiveChangeWhenNotEnoughMoney() {
        double itemPrice = 0;
        double currentBalance = 2;
        moneyService.dispenseChange(currentBalance, itemPrice);
        assertEquals(output.toString(), "Please take your change £2.00\n");
    }
    @After
    public void cleanUp() {
        System.setOut(System.out);
    }
}
