import java.util.ArrayList;
import java.util.List;

public class Party extends Event {
    List<Event> events;

    Party(String title,String date, String description) {
        super(title,date,description);
        events = new ArrayList<>();
    }

    public void addPerson(Person person) {
        for (Person value : persons)
            if (value.equals(person)) return;
        persons.add(person);
    }

    public int getAudienceCount() { return persons.size(); }

    public void addEvent(Event e) {
        events.add(e);
        for (Person person: e.persons)
            addPerson(person);
    }
}
