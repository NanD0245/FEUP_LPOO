package atm;

import java.util.Objects;

public class ATM {
    String bank, city;
    int id;
    public ATM(int id, String city, String bank) {
        this.id = id;
        this.city = city;
        this.bank = bank;
    }

    public int getID() { return id; }

    @Override
    public String toString() {
        return "ATM " + id + " (" + city + ", " + bank + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ATM atm = (ATM) o;
        return id == atm.id && Objects.equals(bank, atm.bank) && Objects.equals(city, atm.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bank, city, id);
    }
}
