package model;

import discountStrategy.DiscountStrategy;
import java.time.LocalDate;

public class Coupon {

    private final String code;
    private final DiscountStrategy discountStrategy;
    private final LocalDate expiry;
    private final int maxUsage;

    public Coupon(String code, DiscountStrategy discountStrategy, LocalDate expiry, int maxUsage) {
        if (maxUsage <= 0) {
            throw new IllegalArgumentException("Max Usage should be greater then 0");
        }
        this.code = code;
        this.discountStrategy = discountStrategy;
        this.expiry = expiry;
        this.maxUsage = maxUsage;
    }

    public String getCode() {
        return code;
    }

    public LocalDate getExpiry() {
        return expiry;
    }

    public int getMaxUsage() {
        return maxUsage;
    }

    public double calculateDiscount(Cart cart) {
        return discountStrategy.calculateDiscount(cart);
    }

}
