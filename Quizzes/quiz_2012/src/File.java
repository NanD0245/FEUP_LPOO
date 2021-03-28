import java.util.List;

public class File extends Node {
    int size;
    public File(Folder parent, String name) throws DuplicateNameException {
        super(parent, name);
        this.size = 0;
    }

    public File(Folder folder, String name, int size) throws DuplicateNameException {
        super(folder,name);
        this.size = size;
    }

    @Override
    public Object[] getChild() {
        return null;
    }

    @Override
    public int getSize() { return size; }

    @Override
    public String getPath() {
        return parent.getPath() + formatter.getSeparator() + name;
    }

    @Override
    public void setFormatter(NameFormatter formatter) { this.formatter = formatter; }

    @Override
    public File clone(Folder folder, String name) throws DuplicateNameException {
        return new File(folder,name,size);
    }

    @Override
    public void update(NameFormatter formatter) { this.formatter = formatter; }
}
