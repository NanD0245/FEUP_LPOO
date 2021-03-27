package atm;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Session implements Countable {
    ATM atm;

    List<Movement> movements;

    public Session(ATM atm) {
        this.atm = atm;
        movements = new ArrayList<>();
    }

    public ATM getATM() { return atm; }


    public void addTransaction(Movement movement) {
        movements.add(movement);
    }


    @Override
    public int count() { return movements.size(); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        return Objects.equals(atm, session.atm) && Objects.equals(movements, session.movements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(atm, movements);
    }
}
