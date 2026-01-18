package services;

import model.*;
import java.util.*;

public class CartService {

    private final Map<String, Cart> carts;
    private final CouponEngine couponEngine;

    public CartService(CouponEngine couponEngine) {
        this.carts = new HashMap();
        this.couponEngine = couponEngine;
    }

    public Cart createCart(String cartId) {
        Cart cart = new Cart(cartId);
        carts.put(cartId, cart);
        return cart;
    }

    public void addItemInCart(String cartId, Item item) {
        Cart cart = getCart(cartId);
        cart.addItem(item);
    }

    public PriceBreakdown applyCoupon(String cartId, Coupon coupon) {
        Cart cart = getCart(cartId);
        return couponEngine.applyCoupon(coupon, cart);
    }

    public Cart getCart(String cartId) {
        Cart cart = carts.get(cartId);
        if (cart == null) {
            throw new IllegalArgumentException("Cart not found: " + cartId);
        }
        return cart;
    }
}
