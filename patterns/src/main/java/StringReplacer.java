public class StringReplacer implements StringTransformer {
    private char old_ch, new_ch;

    StringReplacer(char a, char b)  {old_ch = a; new_ch = b; }

    @Override
    public void execute(StringDrink drink) {
        StringBuilder res = new StringBuilder(drink.getText());
        for (int i = 0; i < res.length(); i++)
            if (res.charAt(i) == old_ch)
                res.setCharAt(i,new_ch);
        drink.setText(res.toString());
    }

    @Override
    public void undo(StringDrink drink) {
        char tmp = old_ch;
        old_ch = new_ch;
        new_ch = tmp;
        execute(drink);
    }
}
