package couponValidator;

import java.time.LocalDate;
import model.Cart;
import model.Coupon;

public class ExpireValidator implements CouponValidator {

    public void validate(Coupon coupon, Cart cart) {
        if (coupon.getExpiry().isBefore(LocalDate.now())) {
            throw new IllegalStateException("Coupon has expired");
        }
    }
}
