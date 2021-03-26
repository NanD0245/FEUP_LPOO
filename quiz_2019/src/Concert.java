import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Concert {
    String city, country, date;
    List<Act> acts;
    List<Ticket> tickets;

    public Concert(String city, String country, String date) {
        this.city = city;
        this.country = country;
        this.date = date;
        acts = new ArrayList<>();
        tickets = new ArrayList<>();
    }

    public String getCity() { return city; }

    public String getCountry() { return country; }

    public String getDate() { return date; }

    public void addAct(Act act) { acts.add(act); }

    public List<Act> getActs() { return acts; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Concert concert = (Concert) o;
        return Objects.equals(city, concert.city) && Objects.equals(country, concert.country) && Objects.equals(date, concert.date) && Objects.equals(acts, concert.acts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, country, date, acts);
    }

    public boolean isValid(Ticket ticket) {
        if ( this.equals(ticket.getConcert()) && ticket.getNumber() > 0 ) {
            for (Ticket t: tickets)
                if (t.getNumber() == ticket.getNumber())
                    return false;
            return true;
        }
        return false;
    }

    public boolean participates(Artist artist) {
        for(Act act: acts) {
            if (act.getClass() == Band.class) {
                Band b = (Band) act;
                if (b.containsArtist(artist)) return true;
            }
            else {
                Artist a = (Artist) act;
                if (a.equals(artist)) return true;
            }
        }
        return false;
    }

    public void addTicket(Ticket ticket) { tickets.add(ticket); }
}
