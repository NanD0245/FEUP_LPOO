import java.util.ArrayList;
import java.util.List;

public class Band extends Act {
    private final String name, country;
    List<Artist> artists;

    public Band(String name, String country) {
        this.name = name;
        this.country = country;
        artists = new ArrayList<>();
    }

    @Override
    public String getName() { return name; }

    @Override
    public String getCountry() { return country; }

    public void addArtist(Artist artist) { artists.add(artist); }

    public List<Artist> getArtists() { return artists; }

    public boolean containsArtist(Artist artist) {
        for (Artist a: artists)
            if(a.equals(artist))
                return true;
        return false;
    }
}
