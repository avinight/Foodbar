package recipe.foodbar.entities.Ingredient;

public class IngredientBuilder {
    private String name;
    private float size;

    public IngredientBuilder name(String name) {
        this.name = name;
        return this;
    }

    public IngredientBuilder size(float size) {
        this.size = size;
        return this;
    }

    public Ingredient createIngredient() {
        return new Ingredient(name, size);
    }
}