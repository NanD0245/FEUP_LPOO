public class DOSFormatter implements NameFormatter {
    char separator;

    DOSFormatter() {
        this.separator = '\\';
    }

    @Override
    public char getSeparator() { return separator; }
}
