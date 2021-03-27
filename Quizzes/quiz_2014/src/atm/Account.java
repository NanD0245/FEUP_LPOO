package atm;

public class Account {
    String name;
    double balance;

    Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() { return name; }

    public double getBalance() { return balance; }
}
