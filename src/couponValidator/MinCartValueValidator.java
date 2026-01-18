package couponValidator;

import model.Cart;
import model.Coupon;

public class MinCartValueValidator implements CouponValidator {

    private final double minCartValue;

    public MinCartValueValidator(double minCartValue) {
        this.minCartValue = minCartValue;
    }

    public void validate(Coupon coupon, Cart cart) {
        if (cart.totalAmount() < minCartValue) {
            throw new IllegalStateException(
                    "Minimum cart value required: " + minCartValue
            );
        }
    }

}
