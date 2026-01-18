package discountStrategy;

import model.Cart;

public class FixedDiscountStrategy implements DiscountStrategy {

    private final double amount;

    public FixedDiscountStrategy(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
        this.amount = amount;
    }

    public double calculateDiscount(Cart cart) {
        return Math.min(amount, cart.totalAmount());
    }

}
