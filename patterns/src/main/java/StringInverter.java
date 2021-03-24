public class StringInverter implements StringTransformer {
    @Override
    public void execute(StringDrink drink) {
        StringBuilder inverted = new StringBuilder(drink.getText());
        inverted.reverse();
        drink.setText(inverted.toString());
    }

    @Override
    public void undo(StringDrink drink) {
        execute(drink);
    }
}
