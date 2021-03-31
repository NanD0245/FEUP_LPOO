package com.aor.refactoring.example1;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderLine> lines;
    double total;

    public Order() {
        this.lines = new ArrayList<>();
        this.total = 0;
    }

    public void add(Product product, int quantity) {
        lines.add(new OrderLine(product, quantity));
        total += product.getPrice() * quantity;
    }

    public boolean isElegibleForFreeDelivery() { return total > 100; }

    public String printOrder() {
        StringBuilder printBuffer = new StringBuilder();

        for (OrderLine line : lines)
            printBuffer.append(line);

        printBuffer.append("Total: ").append(total);

        return printBuffer.toString();
    }
}