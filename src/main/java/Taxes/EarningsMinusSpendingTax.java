package Taxes;

public class EarningsMinusSpendingTax extends TaxSystem {
    private static final double TAX_RATE = 0.15;

    //УСН доходы минус расходы — налог 15% от разницы доходов и расходов.
    @Override
    public int calcTaxFor(int debit, int credit) {
        if (debit > Math.abs(credit)) {
            int tax = (int)((debit-Math.abs(credit)) * TAX_RATE);
            return Math.max(0, tax);
        } else {
            return 0;
        }
    }
}
