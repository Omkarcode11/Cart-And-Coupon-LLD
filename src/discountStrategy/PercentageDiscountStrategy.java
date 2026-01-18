package discountStrategy;

import model.Cart;

public class PercentageDiscountStrategy implements DiscountStrategy {

    private final double percentage;
    private final double maxCap;

    public PercentageDiscountStrategy(double percentage, double maxCap) {
        if (percentage <= 0) {
            throw new IllegalArgumentException("Percentage must be grater than 0");
        }
        if (maxCap <= 0) {
            throw new IllegalArgumentException("Maxcap must be grater than 0");
        }
        this.maxCap = maxCap;
        this.percentage = percentage;
    }

    public double calculateDiscount(Cart cart) {
        double discount = cart.totalAmount() * (percentage / 100);
        return Math.min(discount, maxCap);

    }

}
