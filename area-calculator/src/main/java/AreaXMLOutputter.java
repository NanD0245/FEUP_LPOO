public class AreaXMLOutputter {
    private AreaAggregator areaAggregator;

    AreaXMLOutputter(AreaAggregator areaAggregator) { this.areaAggregator = areaAggregator; }

    public String output() {
        return "<area>" + areaAggregator.sum() + "</area>";
    }
}
