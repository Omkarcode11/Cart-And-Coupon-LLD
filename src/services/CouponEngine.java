package services;

import java.util.List;
import couponValidator.CouponValidator;
import model.Cart;
import model.Coupon;
import model.PriceBreakdown;

import java.util.Objects;

public class CouponEngine {

    public final List<CouponValidator> validators;

    public CouponEngine(List<CouponValidator> validators) {
        this.validators = Objects.requireNonNull(validators);
    }

    public PriceBreakdown applyCoupon(Coupon coupon, Cart cart) {
        Objects.requireNonNull(coupon);
        Objects.requireNonNull(cart);

        for (CouponValidator validator : validators) {
            validator.validate(coupon, cart);
        }

        double discount = coupon.calculateDiscount(cart);

        return new PriceBreakdown(cart.totalAmount(), discount);
    }
}
