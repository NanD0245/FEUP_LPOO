package com.aor.numbers;

public class DivisibleByFilter implements IListFilter {
    private Integer div;

    DivisibleByFilter(Integer div) {this.div = div; }

    @Override
    public boolean accept(Integer number) {
        return number % div == 0;
    }
}
