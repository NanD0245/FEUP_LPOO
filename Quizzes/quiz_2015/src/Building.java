import java.util.ArrayList;
import java.util.List;

public class Building extends Facility{
    String name;
    int minFloor, maxFloor;

    List<Room> rooms;

    Building(String name, int minFloor, int maxFloor) throws IllegalArgumentException {
        if (minFloor > maxFloor) throw new IllegalArgumentException();
        this.name = name;
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
        rooms = new ArrayList<>();
    }

    public String getName() { return name; }

    public int getMaxFloor() { return maxFloor; }

    public int getMinFloor() { return minFloor; }

    @Override
    public String toString() {
        return "Building(" + name + ")";
    }

    public void addRoom(Room room) throws DuplicateRoomException{
        for (Room room1: rooms)
            if (room1.equals(room)) throw new DuplicateRoomException();
        rooms.add(room);
    }

    public int getCapacity() {
        int sum = 0;
        for (Room room: rooms)
            sum += room.capacity;
        return sum;
    }

    @Override
    public boolean canEnter(User user) {
        for (Room room: rooms)
            if (room.canEnter(user)) return true;
        return false;
    }
}
