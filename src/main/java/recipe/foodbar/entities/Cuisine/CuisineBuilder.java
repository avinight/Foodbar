package recipe.foodbar.entities.Cuisine;

public class CuisineBuilder {
    private String name;
    private String id;

    public CuisineBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CuisineBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public Cuisine createCuisine() {
        return new Cuisine(name, id);
    }
}