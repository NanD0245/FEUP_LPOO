import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Room extends Facility {
    Building building;
    String number;
    int floor, capacity;

    List<User> users;

    public Room(Building building, String number, int floor) throws IllegalArgumentException, DuplicateRoomException {
        if (floor > building.getMaxFloor() || floor < building.getMinFloor()) throw new IllegalArgumentException();
        this.building = building;
        this.number = number;
        this.floor = floor;
        this.capacity = 0;
        building.addRoom(this);
        users = new ArrayList<>();
    }

    public Room(Building building, String number, int floor, int capacity) throws IllegalArgumentException, DuplicateRoomException {
        if (floor > building.getMaxFloor() || floor < building.getMinFloor()) throw new IllegalArgumentException();
        this.building = building;
        this.number = number;
        this.floor = floor;
        this.capacity = capacity;
        building.addRoom(this);
        users = new ArrayList<>();
    }

    public String getName() { return building.getName() + number; }

    public Building getBuilding() { return building; }

    public int getFloor() { return floor; }

    public String getNumber() { return number; }

    @Override
    public String toString() {
        return "Room(" + building.getName() + "," + number + ")";
    }

    public int getCapacity() { return capacity; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return floor == room.floor && Objects.equals(building, room.building) && Objects.equals(number, room.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(building, number, floor, capacity);
    }

    public void authorize(User user) {
        for (User user1 : users)
            if (user1.equals(user)) return;
        users.add(user);
    }
    
    public boolean canEnter(User user) {
        for (User user1 : users)
            if (user1.equals(user)) return true;
        return false;
    }
}
