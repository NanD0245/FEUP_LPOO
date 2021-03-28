import java.util.ArrayList;
import java.util.List;

public class Folder extends Node{
    List<Node> children;

    public Folder(Folder parent, String name) throws DuplicateNameException {
        super(parent, name);
        children = new ArrayList<>();
    }

    public boolean addChild(Node node) {
        for (Node node1: children) {
            if (node1.getName().equals(node.getName())) return false;
        }
        children.add(node);
        return true;
    }

    public void removeChild(Node node) { children.remove(node); }

    @Override
    public Object[] getChild() { return children.toArray(); }

    @Override
    public int getSize() {
        int sum = 0;
        for(Node child: children)
            sum += child.getSize();
        return sum;
    }

    @Override
    public String getPath() {
        if (parent == null) return "";
        return parent.getPath() + formatter.getSeparator() + name;
    }

    @Override
    public void setFormatter(NameFormatter formatter) {
        this.formatter = formatter;
        for (Node node: children)
            node.setFormatter(formatter);
    }

    @Override
    public Folder clone(Folder folder, String name) throws DuplicateNameException {
        Folder new_clone = new Folder(folder,name);
        new_clone.setFormatter(this.formatter);
        for (Node child: children)
            new_clone.addChild(child.clone(new_clone, child.getName()));
        return new_clone;
    }


    public Node getChildByName(String name) {
        for (Node node: children)
            if (node.getName().equals(name)) return node;
        return null;
    }

    @Override
    public void update(NameFormatter formatter) {
        this.formatter = formatter;
        for (Node node: children)
            node.update(formatter);
    }
}


