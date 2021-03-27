import java.util.ArrayList;
import java.util.List;

public class BoxOffice {

    public static List<Ticket> buy(Concert concert, int number) throws InvalidTicket {
        List<Ticket> res = new ArrayList<>();
        int i = 1;
        while (number > 0) {
            try {
                Ticket ticket = new Ticket(i, concert);
                res.add(ticket);
                number--;
                concert.addTicket(ticket);
            } catch (InvalidTicket e) { i++; }
        }
        return res;
    }
}
