package geometry;

import java.util.Objects;

public class Ponto implements Comparable{
    int x;
    int y;

    Ponto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }

    public int getY() { return y; }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ponto ponto = (Ponto) o;
        return x == ponto.x && y == ponto.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }



    @Override
    public int compareTo(Object o) {
        Ponto p = (Ponto) o;
        if (this.equals(p)) return 0;
        else if (x > p.getX()) return 1;
        else if (x == p.getX() && y > p.getY()) return 1;
        else return -1;
    }
}
