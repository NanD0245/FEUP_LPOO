package geometry;

public class FiguraComposta extends Figura implements Countable {
    Figura[] figuras;
    public FiguraComposta(Figura[] figuras) {
        this.figuras = figuras;
    }

    @Override
    public double getArea() {
        double sum = 0;
        for (Figura figura: figuras)
            sum += figura.getArea();
        return sum;
    }

    @Override
    public double getPerimetro() {
        double sum = 0;
        for (Figura figura: figuras)
            sum += figura.getPerimetro();
        return sum;
    }

    @Override
    public int count() {
        return figuras.length;
    }
}
