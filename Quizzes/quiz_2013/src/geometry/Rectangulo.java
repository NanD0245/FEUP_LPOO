package geometry;

public class Rectangulo extends Figura {
    Ponto p1, p2;
    public Rectangulo(int x1, int y1, int x2, int y2) {
        p1 = new Ponto(x1,y1);
        p2 = new Ponto(x2,y2);
    }

    @Override
    public double getArea() {
        return Math.abs(p1.getX() - p2.getX()) * Math.abs(p1.getY() - p2.getY());
    }

    @Override
    public double getPerimetro() {
        return 2*(Math.abs(p1.getX() - p2.getX()) + Math.abs(p1.getY() - p2.getY()));
    }
}
