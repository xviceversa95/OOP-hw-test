package Company;

import Deals.Deal;
import Deals.Expenditure;
import Deals.Sale;
import Taxes.EarningsTax;
import Taxes.TaxSystem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CompanyActionsTests {


    @Test
    public void testApplyDeals() {
        TaxSystem earningsTax = new EarningsTax();
        Company company = new Company("Test1", earningsTax);
        company.debit = 1000;
        company.credit = -500;
        Deal[] deals = {
                new Sale("Банан", 100),
                new Sale("Яблоко", 100),
                new Expenditure("Стол", 200),
                new Expenditure("Стул", 200)
        };
        int expectedBalance = 300;
        Assertions.assertEquals(expectedBalance, company.applyDeals(deals));

    }
}
