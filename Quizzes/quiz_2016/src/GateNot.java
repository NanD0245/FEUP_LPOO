public class GateNot extends LogicGate {

    public GateNot(LogicVariable output, LogicVariable input) throws ColisionException, CycleException {
        super(output,input,"NOT");
        super.output.setValue(!input.getValue());
        super.output.setFormula("NOT(" + input.getFormula() + ")");
    }


    @Override
    public boolean update() {
        return !getInputs()[0].getValue();
    }
}
