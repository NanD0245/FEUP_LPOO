public class StringCaseChanger implements StringTransformer {
    @Override
    public void execute(StringDrink drink) {
        StringBuilder res = new StringBuilder(drink.getText());
        for (int i = 0; i < drink.getText().length(); i++) {
            char ch = drink.getText().charAt(i);

            if (Character.isLowerCase(ch)) res.setCharAt(i,Character.toUpperCase(ch));
            else res.setCharAt(i,Character.toLowerCase(ch));

        }
        drink.setText(res.toString());
    }

    @Override
    public void undo(StringDrink drink) {
        execute(drink);
    }
}
