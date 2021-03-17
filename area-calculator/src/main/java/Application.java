public class Application {
    public static void main(String[] args) {
        AreaAggregator aggregator = new AreaAggregator();
        AreaStringOutputter stringOutputter = new AreaStringOutputter(aggregator);
        AreaXMLOutputter xmlOutputter = new AreaXMLOutputter(aggregator);
        aggregator.addShape(new Circle(2.2));
        aggregator.addShape(new Square(5.3));
        aggregator.addShape(new Ellipse(3.4, 2.7));
        aggregator.addShape(new Square(2));
        aggregator.addShape(new Rectangle(4,2));
        aggregator.addShape(new Triangle(4,3));

        System.out.println(stringOutputter.output());
        System.out.println(xmlOutputter.output());
    }
}
