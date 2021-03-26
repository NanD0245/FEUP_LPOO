import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Icecream {
    private final List<Flavor> scoops;

    Icecream() {scoops = new ArrayList<>(); }

    public void addScoop(Flavor flavor) { scoops.add(flavor); }

    public int getScoopCount() { return scoops.size(); }

    public boolean contains(String name) {
        for (Flavor flavor: scoops)
            if (flavor.getName() == name)
                return true;
        return false;
    }

    public int getFlavorCount() {
        List<Flavor> res = new ArrayList<>(new HashSet<>(scoops));
        //Set<Flavor> res = new HashSet<>(scoops);
        return res.size();
    }

    public void undoLast() { scoops.remove(scoops.size() - 1); }
}
