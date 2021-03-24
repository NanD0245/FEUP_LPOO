import java.util.List;

public class StringTransformerGroup implements StringTransformer {
    private List<StringTransformer> transformers;

    StringTransformerGroup(List<StringTransformer> transformers) {this.transformers = transformers; }

    @Override
    public void execute(StringDrink drink) {
        for (StringTransformer a : transformers)
            a.execute(drink);
    }

    @Override
    public void undo(StringDrink drink) {
        for (StringTransformer a : transformers)
            a.undo(drink);
    }
}
