import java.util.List;

public class StringRecipe {
    private List<StringTransformer> transformers;

    StringRecipe(List<StringTransformer> transformers)  {this.transformers = transformers; }

    public void mix(StringDrink drink) {
        for (StringTransformer a : transformers)
            a.execute(drink);
    }
}
