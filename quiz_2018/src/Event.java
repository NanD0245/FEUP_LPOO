import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Event {
    protected String title, description, date;
    List<Person> persons;

    public Event(String title) {
        this.title = title;
        description = "";
        date = "";
        persons = new ArrayList<>();
    }

    public Event(String title, String date) {
        this.title = title;
        this.date = date;
        description = "";
        persons = new ArrayList<>();
    }

    public Event(String title, String date, String description) {
        this.title = title;
        this.description = description;
        this.date = date;
        persons = new ArrayList<>();
    }

    public Event(Event e) {
        this.title = e.title;
        this.date = e.date;
        this.description = e.description;
        persons = new ArrayList<>();
    }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    @Override
    public String toString() {
        return title + " is a " + description + " and will be held at " + date + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(title, event.title) && Objects.equals(description, event.description) && Objects.equals(date, event.date) && Objects.equals(persons, event.persons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, date, persons);
    }

    public void addPerson(Person person) {
        for (Person person1 : persons)
            if (person1.name.equals(person.name))
                return;
        persons.add(person);
    }

    public int getAudienceCount() { return persons.size(); }
}
