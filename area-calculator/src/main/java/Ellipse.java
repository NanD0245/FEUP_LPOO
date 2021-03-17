public class Ellipse implements Shape {
    private double x;
    private double y;

    Ellipse(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }

    public void setX(double x) { this.x = x; }

    public double getY() { return y; }

    public void setY(double y) { this.y = y; }

    @Override
    public double getArea() {
        return Math.PI*x*y;
    }
}
