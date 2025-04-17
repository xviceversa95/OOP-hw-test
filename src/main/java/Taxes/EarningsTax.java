package Taxes;

public class EarningsTax extends TaxSystem {
    private static final double TAX_RATE = 0.06;

    //УСН доходы — налог 6% от доходов;
    @Override
    public int calcTaxFor(int debit, int credit) {
       return (int)(TAX_RATE * debit);
    }
}
