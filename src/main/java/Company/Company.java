package Company;


import Deals.Deal;
import Taxes.TaxSystem;

public class Company {
    protected String title;
    public int debit;
    public int credit;
    protected TaxSystem taxSystem;


    public Company(String title, TaxSystem taxSystem) {
        this.title = title;
        this.taxSystem = taxSystem;
    }

    //если amount больше 0, то увеличивается значение debit на amount
    public void shiftMoney(int amount) {
        if (amount > 0) {
            debit += amount;
        }

        //если amount меньше 0, то увеличивается значение credit на Math.abs(amount);
        if (amount < 0) {
            credit -= Math.abs(amount);
        }
    }

    //устанавливаем систему налогообложения для компании:
    public void setTaxSystem(TaxSystem taxSystem) {
        this.taxSystem = taxSystem;
    }

    //рассчитает с помощью выбранной этой компанией системы налогооблажения размер налогов;
    //выведет сообщение на экран вида: Компания <название> уплатила налог в размере: <сумма> руб
    //обнулит счётчики debit и credit

    public void payTaxes() {
        int tax = taxSystem.calcTaxFor(debit, credit);
        System.out.println("Компания " + title + " уплатила налог в размере " + tax + " руб.");
        debit = 0;
        credit = 0;
    }


    //компания применяет все сделки из массива сделок (т. е. увеличивает credit на creditChange, debit на debitChange)
    //выплачивает все налоги;
    //возвращает из метода разницу доходов и расходов, которая была на момент старта уплаты налогов.

    public int applyDeals(Deal[] deals) {
        for (Deal deal : deals) {
            if (deal.getCreditChange() > 0) {
                shiftMoney(-deal.getCreditChange());
            }
            if (deal.getDebitChange() > 0) {
                shiftMoney(deal.getDebitChange());
            }
        }
        int balance = debit - Math.abs(credit);
        payTaxes();
        return balance;
    }
}


