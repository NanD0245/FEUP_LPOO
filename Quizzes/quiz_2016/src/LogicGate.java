import org.xml.sax.HandlerBase;

public abstract class LogicGate {

    protected LogicVariable output;
    protected LogicVariable[] inputs;
    protected String symbol;

    public LogicGate(LogicVariable output, LogicVariable input1, LogicVariable input2, String symbol) throws ColisionException, CycleException {
        if (input1.getCalculatedBy() != null && (input1.getCalculatedBy().getInputs()[0].equals(output) ||
                input1.getCalculatedBy().getInputs()[1].equals(output)) ||
                input2.getCalculatedBy() != null && (input2.getCalculatedBy().getInputs()[0].equals(output) ||
                input2.getCalculatedBy().getInputs()[1].equals(output)))
            throw new CycleException();

        inputs = new LogicVariable[]{input1,input2};
        this.output = output;
        this.symbol = symbol;
        output.setCalculatedBy(this);
    }

    public LogicGate(LogicVariable output, LogicVariable input, String symbol) throws ColisionException, CycleException {
        if (input.getCalculatedBy() != null && input.getCalculatedBy().getInputs()[0].equals(output))
            throw new CycleException();

        inputs = new LogicVariable[]{input};
        this.output = output;
        this.symbol = symbol;
        output.setCalculatedBy(this);
    }

    public LogicVariable[] getInputs() { return inputs; }
    public LogicVariable getOutput() { return output; }
    public String getSymbol() { return symbol; }

    public String getFormula() {
        return output.getFormula();
    }

    public abstract boolean update();
}
