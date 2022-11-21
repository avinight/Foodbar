package recipes.foodbar.entities;

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


    public static class IngredientBuilder {
        private String name;
        private float size;

        private IngredientBuilder() {
        }

        public IngredientBuilder name(final String name) {
            this.name = name;
            return this;
        }

        public IngredientBuilder size(final float size) {
            this.size = size;
            return this;
        }

        public Ingredient build() {
            return new Ingredient(name, size);
        }
    }
    public String getName() {
        return name;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size){
        this.size = size;
    }
}