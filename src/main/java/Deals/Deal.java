package Deals;

public class Deal {
    public String comment;
    public int creditChange;
    public int debitChange;


    public Deal(String comment, int creditChange, int debitChange) {
        this.comment = comment;
        this.creditChange = creditChange;
        this.debitChange = debitChange;
    }

    public int getCreditChange() {
        return creditChange;
    }

    public int getDebitChange() {
        return debitChange;
    }


}
