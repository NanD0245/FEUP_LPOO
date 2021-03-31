import java.util.Arrays;
import java.util.List;

public class MargueritaCertifier extends PizzaCertifier {
    private static List<Ingredient> ingredients = Arrays.asList(new Ingredient("Mozzarella"), new Ingredient("Tomato"), new Ingredient("Basil"));

    @Override
    public boolean isCertified(Pizza pizza) {
        if (pizza.getIngredientCount() != 3) return false;
        for (Ingredient i: ingredients) if (!pizza.contains(i)) return false;
        return true;
    }
}
