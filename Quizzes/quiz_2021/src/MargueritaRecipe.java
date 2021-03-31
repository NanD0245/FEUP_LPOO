import java.util.Arrays;
import java.util.List;

public class MargueritaRecipe extends Recipe {

    @Override
    public Pizza makeMediumPizza() {
        Pizza pizza1 = new MediumPizza();
        pizza1.addIngredient(new Ingredient("Tomato"));
        pizza1.addIngredient(new Ingredient("Mozzarella"));
        pizza1.addIngredient(new Ingredient("Basil"));
        return pizza1;
    }
}
