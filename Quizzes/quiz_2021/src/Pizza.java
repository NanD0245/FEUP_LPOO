import java.util.List;

public interface Pizza {
    boolean addIngredient(Ingredient ingredient1);
    int getIngredientCount();
    List<Ingredient> getIngredients();
    double getPrice();
    void setPrice(double price);
    boolean contains(Ingredient ingredient);
}
