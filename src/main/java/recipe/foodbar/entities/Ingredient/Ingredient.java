package recipe.foodbar.entities.Ingredient;

public class Ingredient {
    private final String name;
    private float size;

    Ingredient(String name, float size) {
        this.name = name;
        this.size = size;
    }

    public static IngredientBuilder builder() {
        return new IngredientBuilder();
    }

    public String getName() {
        return name;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }
}