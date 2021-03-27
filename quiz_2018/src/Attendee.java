public class Attendee extends User {
    boolean hasPaid;

    public Attendee(String name, int age) { super(name, age); hasPaid = false; }

    public Attendee(String name) { super(name, 0);hasPaid = false; }

    public boolean hasPaid() { return hasPaid; }

    @Override
    public String toString() {
        return "Attendee " + name + (hasPaid ? " has" : " hasn't") + " paid its registration.";
    }

}
