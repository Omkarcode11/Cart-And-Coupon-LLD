package discountStrategy;

import model.Cart;

public interface DiscountStrategy {

    double calculateDiscount(Cart cart);
}
