import java.util.ArrayList;
import java.util.List;

public class MediumPizza implements Pizza {
    private double price;
    private List<Ingredient> ingredients;

    MediumPizza() {
        this.price = 0.0;
        ingredients = new ArrayList<>();
    }

    @Override
    public boolean addIngredient(Ingredient ingredient) {
        for (Ingredient ingredient1 : ingredients)
            if (ingredient1.equals(ingredient))
                return false;
        this.ingredients.add(ingredient);
        return true;
    }

    @Override
    public int getIngredientCount() { return ingredients.size(); }

    @Override
    public List<Ingredient> getIngredients() { return ingredients; }

    @Override
    public void setPrice(double price) { this.price = price; }

    @Override
    public double getPrice() { return price; }

    @Override
    public boolean contains(Ingredient ingredient) {
        for (Ingredient ingredient1 : ingredients)
            if (ingredient.equals(ingredient1)) return true;
        return false;
    }
}
