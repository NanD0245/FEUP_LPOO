public class UnixFormatter implements NameFormatter {
    char separator;

    UnixFormatter() {
        this.separator = '/';
    }

    @Override
    public char getSeparator() { return separator; }
}
