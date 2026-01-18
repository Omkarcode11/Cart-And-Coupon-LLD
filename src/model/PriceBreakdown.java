package model;

public class PriceBreakdown {

    private final double originalAmount;
    private final double discountAmount;
    private final double finalAmount;

    public PriceBreakdown(double originalAmount, double discountAmount) {
        if (originalAmount <= 0) {
            throw new IllegalArgumentException("Original amount is greater than zero");
        }
        if (discountAmount <= 0) {
            throw new IllegalArgumentException("Discount amount is greater than zero");
        }
        this.originalAmount = originalAmount;
        this.discountAmount = discountAmount;
        this.finalAmount = round(originalAmount - discountAmount);
    }

    public double getOriginalAmount() {
        return originalAmount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    public double round(double amount) {
        return Math.round(amount * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return "PriceBreakdown [originalAmount=" + originalAmount + ", discountAmount=" + discountAmount
                + ", finalAmount=" + finalAmount + "]";
    }
}
