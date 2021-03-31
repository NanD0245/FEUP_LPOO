import java.util.List;

public class SlicedPizza implements Pizza {
    private int slices;
    private Pizza pizza;

    public SlicedPizza(Pizza pizza, int slices) {
        this.pizza = pizza;
        this.slices = slices;
    }

    public int getSlices() { return slices; }

    @Override
    public boolean addIngredient(Ingredient ingredient) {
        return pizza.addIngredient(ingredient);
    }

    @Override
    public int getIngredientCount() {
        return pizza.getIngredientCount();
    }

    @Override
    public List<Ingredient> getIngredients() {
        return pizza.getIngredients();
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 2;
    }

    @Override
    public void setPrice(double price) { pizza.setPrice(price); }

    @Override
    public boolean contains(Ingredient ingredient) { return pizza.contains(ingredient); }
}
