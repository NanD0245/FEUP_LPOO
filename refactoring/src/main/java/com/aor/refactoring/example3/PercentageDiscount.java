package com.aor.refactoring.example3;

public class PercentageDiscount implements Discount {
    private final double percentage;

    PercentageDiscount(double percentage) { this.percentage = percentage; }

    @Override
    public double applyDiscount(double price) { return price - price * percentage; }
}
