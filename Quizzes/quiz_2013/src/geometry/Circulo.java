package geometry;

public class Circulo extends Figura{
    int raio;
    Ponto centro;

    public Circulo(Ponto centro, int raio) {
        if (raio < 0) throw new IllegalArgumentException();
        this.centro = centro;
        this.raio = raio;
    }

    public Ponto getCentro() { return centro; }

    public int getRaio() { return raio; }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(raio,2);
    }

    @Override
    public double getPerimetro() {
        return 2*raio*Math.PI;
    }
}
