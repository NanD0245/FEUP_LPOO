public class FileSystem {
    String type;
    Folder root;
    NameFormatter formatter;

    public FileSystem(String type) throws DuplicateNameException {
        this.type = type;
        this.root = new Folder(null,"root");
        formatter = null;
    }

    public String getType() { return type; }

    public Folder getRoot() {
        return root;
    }
    public NameFormatter getFormatter() { return formatter; }

    public void setNameFormatter(NameFormatter formatter) { this.formatter = formatter; root.update(formatter);}
}
