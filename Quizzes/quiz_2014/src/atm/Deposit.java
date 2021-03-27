package atm;

public class Deposit extends Movement{
    public Deposit(ATM atm, Session session, Card card, int id) {
        super(atm,session,card,id);
    }
}
