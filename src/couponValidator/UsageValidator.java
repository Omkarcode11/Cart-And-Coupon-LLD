package couponValidator;

import model.Cart;
import model.Coupon;

public class UsageValidator implements CouponValidator {

    public void validate(Coupon coupon, Cart cart) {
        if (coupon.getMaxUsage() <= 0) {
            throw new IllegalStateException("Coupon usage limit exceeded");
        }
    }
}
