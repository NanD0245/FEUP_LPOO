package atm;

public class Movement {
    protected int id;
    protected double amount;
    protected ATM atm;
    protected Session session;
    protected Card card;

    public Movement(ATM atm, Session session, Card card, int id) {
        this.id = id;
        this.card = card;
        this.atm = atm;
        this.session = session;
        amount = 0;
    }

    public void setAmount(double amount) { this.amount = amount; }

    public double getAmount() { return amount; }
}
