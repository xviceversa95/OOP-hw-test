package Taxes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class TaxSystemsTests {


    //Тестируем расчет налога по доходу:
    @Test
    public void TestEarningTax() {
        TaxSystem taxSystem = new EarningsTax();
       int debit = 1000;
       int credit = -2000;
       int expected = 60;

        int result = taxSystem.calcTaxFor(debit, credit);

        Assertions.assertEquals(expected, result);
    }

    //Тестируем расчет налога из разницы доходов и расходов:
   @Test
   public void TestEarningMinusSpendingTax() {
       TaxSystem taxSystem = new EarningsMinusSpendingTax();
       int debit = 1000;
       int credit = -200;
       int expected = 120;

       int result = taxSystem.calcTaxFor(debit, credit);

       Assertions.assertEquals(expected, result);
   }
}
