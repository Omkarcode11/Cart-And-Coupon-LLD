package couponValidator;

import model.Cart;
import model.Coupon;

public interface CouponValidator {

    void validate(Coupon coupon, Cart cart);
}
