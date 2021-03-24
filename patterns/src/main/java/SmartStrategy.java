import java.util.Collections;

public class SmartStrategy implements OrderingStrategy {
    boolean happyHour;
    private StringBar bar;
    private StringRecipe recipe;
    private StringDrink drink;

    SmartStrategy() {
        happyHour = false;
        bar = new StringBar();
        recipe = new StringRecipe(Collections.emptyList());
        drink = new StringDrink("");
    }

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        if (bar.isHappyHour() || happyHour) {
            bar.order(drink, recipe);
        }
        else {this.drink = drink; this.recipe = recipe; this.bar = bar; }
    }

    @Override
    public void happyHourStarted(StringBar bar) {
        happyHour = true;
        if (!drink.getText().isEmpty()) this.wants(drink,recipe,bar);
    }

    @Override
    public void happyHourEnded(StringBar bar) {
        happyHour = false;
    }
}
