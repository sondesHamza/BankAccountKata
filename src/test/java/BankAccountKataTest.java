import model.BankAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAccountKataTest {
    BankAccount account;

    @BeforeEach
    public void intBanlance() {
        account = new BankAccount("Hamza", 001, "First Account", 300, "2022");

    }

    @Test
    public void testWithdrawBank() {

        Assertions.assertEquals(100, account.withdraw(200));
        Assertions.assertEquals(100, account.withdraw(400));
        Assertions.assertEquals(200, account.withdraw(-100));
    }

    @Test
    public void testDipositBank() {

        Assertions.assertEquals(300, account.deposit(-100));
        Assertions.assertEquals(500, account.deposit(200));

    }

    @Test
    public void testPrintStatement() {

        account.deposit(200);
        account.deposit(100);
        account.withdraw(100);
        int size = account.printStatement();
        Assertions.assertEquals(3, size);

    }


}
