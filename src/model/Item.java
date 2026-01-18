package model;

import java.util.Objects;

public final class Item {

    private final String id;
    private final String name;
    private final double unitPrice;
    private final String category;
    private int quantity;

    public Item(String id, String name, double unitPrice, String category, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater then zero");
        }

        if (unitPrice <= 0) {
            throw new IllegalArgumentException("Unit price must be greater than zero");
        }

        this.id = Objects.requireNonNull(id);
        this.name = Objects.requireNonNull(name);
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.category = Objects.requireNonNull(category);
    }

    public double totalPrice() {
        return this.unitPrice * this.quantity;
    }

    public void updateQuantity(int newQuantity) {
        if (newQuantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }

        this.quantity = newQuantity;
    }

    public String getCategory() {
        return category;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

}
