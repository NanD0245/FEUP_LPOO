package com.aor.refactoring.example3;

public class SimpleOrder {
    private Discount discount;
    private final double price;

    public SimpleOrder(double price) {
        this.price = price;
        this.discount = new NullDiscount();
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public double getTotal() { return discount.applyDiscount(price); }
}
