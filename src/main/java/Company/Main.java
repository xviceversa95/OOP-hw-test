package Company;

import Deals.Deal;
import Deals.Expenditure;
import Deals.Sale;
import Taxes.EarningsMinusSpendingTax;
import Taxes.EarningsTax;


public class Main {
    public static void main(String[] args) {

        Deal[] deals = {
                new Sale("Банан", 100),
                new Sale("Яблоко", 100),
                new Expenditure("Стол", 200),
                new Expenditure("Стул", 200)
        };

        Company company = new Company("Солнышко", new EarningsTax());
        company.shiftMoney(400);
        company.shiftMoney(300);
        company.shiftMoney(-600);
        System.out.println("Дебит: " + company.debit);
        System.out.println("Кредит: " + company.credit);

        int balance = company.applyDeals(deals);
        System.out.println("Баланс после совершения: " + balance);

        System.out.println("Дебит: " + company.debit);
        System.out.println("Кредит: " + company.credit);


        Company company2 = new Company("Тестовая Вторая", new EarningsMinusSpendingTax());
        company2.shiftMoney(1000);
        company2.shiftMoney(-500);
        int balance2 = company2.applyDeals(deals);
        System.out.println("Баланс после совершения: " + balance2);

        System.out.println("Дебит: " + company2.debit);
        System.out.println("Кредит: " + company2.credit);

    }
}
