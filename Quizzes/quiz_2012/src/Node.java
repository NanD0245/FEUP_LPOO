import java.util.Objects;

public abstract class Node {
    static int next_number;
    Folder parent;
    String name;
    int number;
    NameFormatter formatter;

    Node(Folder parent, String name) throws DuplicateNameException {
        this.parent = parent;
        this.name = name;
        if (parent != null)
            if (!parent.addChild(this))
                throw new DuplicateNameException();
        if (parent != null)
            this.formatter = parent.getFormatter();
        this.number = ++next_number;
    }

    public static void resetNumbering(int i) { next_number = 0; }

    public Folder getParent() { return parent; }

    public void setParent(Folder parent) { this.parent = parent; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public abstract Object[] getChild();

    public int getNumber() { return number; }

    public abstract int getSize();

    public abstract String getPath();

    public NameFormatter getFormatter() { return formatter; }

    public abstract void setFormatter(NameFormatter formatter);

    public abstract Node clone(Folder folder, String name) throws DuplicateNameException;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(name, node.name) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(parent, name);
    }

    public void move(Folder folder, String name) throws CycleException {
        Folder f = folder.getParent();
        while (f != null) {
            if (f.equals(this)) throw new CycleException();
            f = f.getParent();
        }
        parent.removeChild(this);
        setParent(folder);
        parent.addChild(this);
        setName(name);

    }

    public abstract void update(NameFormatter formatter);
}
