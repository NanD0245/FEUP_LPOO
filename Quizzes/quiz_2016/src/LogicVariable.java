import java.util.Objects;

public class LogicVariable {
    private String name, formula;
    private boolean value;
    private LogicGate calculatedBy;

    public LogicVariable(String name, boolean value) {
        this.name = name;
        this.value = value;
        calculatedBy = null;
        this.formula = name;
    }

    public LogicVariable(String name) {
        this.name = name;
        this.value = false;
        calculatedBy = null;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public boolean getValue() {
        if (calculatedBy != null)
            return calculatedBy.update();
        return value;
    }

    public void setValue(boolean value) { this.value = value; }

    public void setFormula(String formula) { this.formula = formula; }

    public String getFormula() { return formula; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogicVariable that = (LogicVariable) o;
        return Objects.equals(name, that.name);
    }

    public void setCalculatedBy(Object calculatedBy) throws ColisionException {
        if (this.calculatedBy == null)
            this.calculatedBy = (LogicGate) calculatedBy;
        else throw new ColisionException();
    }

    public LogicGate getCalculatedBy() { return calculatedBy; }
}
