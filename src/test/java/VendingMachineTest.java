import com.main.MoneyService;
import com.main.UserInputHandler;
import com.main.VendingMachine;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;

import static org.junit.Assert.assertEquals;

public class VendingMachineTest {
    private VendingMachine vendingMachine;

    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Before
    public void setup() {
     vendingMachine = new VendingMachine(new MoneyService(), new UserInputHandler(), new DecimalFormat());
     System.setOut(new PrintStream(output));
    }

    @Test
    public void shouldDispenseChosenItem() {

        //when
        vendingMachine.dispenseItem(0);
        //then
        assertEquals(output.toString(),"Dispensing: Snickers\n");
    }

    @Test
    public void shouldFindCorrectItem() {
        int itemNumber = 1;
        assertEquals(vendingMachine.findItem(itemNumber), vendingMachine.getStock().get(itemNumber));
    }

    @Test
    public void shouldDispenseItem() {
        vendingMachine.dispenseItem(0);
        assertEquals(output.toString(), "Dispensing: Snickers\n");
    }

    @Test
    public void shouldCheckIfEnoughFunds() {
        String nameOfItem = "Snickers";
        vendingMachine.insufficientFundsError(nameOfItem);
        assertEquals(output.toString(), "Error, Not enough money for Snickers\n");
    }

    @After
    public void resetMethod(){
        System.setOut(System.out);
    }
}
