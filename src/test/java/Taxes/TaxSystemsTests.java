package Taxes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;

public class TaxSystemsTests {

    public static Stream TestEarningTaxData () {
        return Stream.of(
                Arguments.of(60, 1000, -2000),
                Arguments.of(18, 300, -100)
        );
    }

    public static Stream TestEarningMinusSpendingTaxData() {
        return Stream.of(
                Arguments.of(0, 1000, -2000),
                Arguments.of(30, 300, -100)
        );
    }


    //Тестируем расчет налога по доходу:
    @ParameterizedTest
    @MethodSource("TestEarningTaxData")
    public void TestEarningTax(int expected, int debit, int credit) {
       TaxSystem taxSystem = new EarningsTax();

        int result = taxSystem.calcTaxFor(debit, credit);

        Assertions.assertEquals(expected, result);
    }

    //Тестируем расчет налога из разницы доходов и расходов:
   @ParameterizedTest
   @MethodSource("TestEarningMinusSpendingTaxData")
   public void TestEarningMinusSpendingTax(int expected, int debit, int credit) {
       TaxSystem taxSystem = new EarningsMinusSpendingTax();

       int result = taxSystem.calcTaxFor(debit, credit);

       Assertions.assertEquals(expected, result);
   }
}
