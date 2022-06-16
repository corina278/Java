package Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OnlineBankingTest extends BaseTestOB {

    public static final String username = "johndoe";
    public static final String password = "S3cr3tpa55word!";

    @Test
    public void loginTheUser() throws Exception {
        //int initialValue, endValue;
        OB.openOnlineBanking();
        OB.loginUser(username,password);
        System.out.println(OB.countTransactions());
        boolean balance = OB.checkBalance();
        System.out.println(balance);
        Assertions.assertTrue(balance, "The balance is not $350");
        //Assertions.assertEquals(1, endValue - initialValue, "Grape was NOT added successfully!");
       // grape.pickAndCrushGrapes(GRAPE_NAME);
       // grape.Must(GRAPE_NAME);
       // grape.ferment(GRAPE_NAME);
      //  boolean isAdded = grape.isMyGrapeInTable(GRAPE_NAME);
       // System.out.println(isAdded);
       // Assertions.assertTrue(isAdded, "Grape was NOT added successfully!");


    }
}
