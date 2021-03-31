import java.util.List;

public class GenericRecipe extends Recipe {

    private List<Ingredient> ingredients;

    public GenericRecipe(List<Ingredient> ingredients) { this.ingredients = ingredients; }

    @Override
    public Pizza makeMediumPizza() {
        Pizza pizza1 = new MediumPizza();
        for (Ingredient i: ingredients)
            pizza1.addIngredient(i);
        return pizza1;
    }
}
