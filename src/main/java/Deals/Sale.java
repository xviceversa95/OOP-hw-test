package Deals;

public class Sale extends Deal {

    public Sale(String name, int price) {
        super("Продажа " + name + " на " + price + " руб.",
                0, price);
    }
}
