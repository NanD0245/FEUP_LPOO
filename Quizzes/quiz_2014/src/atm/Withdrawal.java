package atm;

public class Withdrawal extends Movement{

    public Withdrawal(ATM atm, Session session, Card card, int id) {
        super(atm,session,card,id);
    }

    @Override
    public String toString() {
        return "Withdrawal at " + atm + " of " + String.format("%.2f", amount);
    }
    //Withdrawal at ATM 987 (Porto, CGD) of 100.00
}
