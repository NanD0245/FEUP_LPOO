import java.util.ArrayList;
import java.util.List;

public class CombinatorialCircuit {
    List<LogicVariable> variables;

    CombinatorialCircuit() {variables = new ArrayList<>(); }

    public boolean addVariable(LogicVariable variable) {
        for (LogicVariable variable1: variables)
            if (variable1.equals(variable))
                return false;
        variables.add(variable);
        return true;
    }

    public Object getVariableByName(String name) {
        for (LogicVariable variable1: variables)
            if (variable1.getName().equals(name)) return variable1;
        return null;
    }
}
