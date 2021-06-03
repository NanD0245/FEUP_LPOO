import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

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
        aggregator.addShape(new House(50));

        System.out.println(stringOutputter.output());
        System.out.println(xmlOutputter.output());

        List<House> houses = new ArrayList<>();

        houses.add(new House(50));
        houses.add(new House(150));
        houses.add(new House(75));

        City city = new City(houses);

        AreaStringOutputter cityStringOutputter = new AreaStringOutputter(city);
        AreaXMLOutputter cityXMLOutputter = new AreaXMLOutputter(city);

        System.out.println(cityStringOutputter.output());
        System.out.println(cityXMLOutputter.output());
    }
}
