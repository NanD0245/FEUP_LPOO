import java.awt.geom.Area;

public class Triangle implements AreaShape {
    private double base;
    private double height;

    Triangle(double base, double height) {
        this.height = height;
        this.base = base;
    }

    public double getHeight() { return height; }

    public void setHeight(double height) { this.height = height; }

    public double getBase() { return base; }

    public void setBase(double base) { this.base = base; }

    @Override
    public double getArea() {
        return (base * height) / 2;
    }

    @Override
    public void draw() {
        System.out.println("Triangle");
    }
}
