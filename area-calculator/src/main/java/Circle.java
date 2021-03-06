public class Circle implements AreaShape {
    private double radius;
    Circle(double radius) { this.radius = radius; }

    public double getRadius() { return radius; }

    public void setRadius(int radius) { this.radius = radius; }

    @Override
    public double getArea() {
        return Math.PI*Math.pow(radius,2);
    }

    @Override
    public void draw() {
        System.out.println("Circle");
    }
}
