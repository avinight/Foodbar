package foodbar.usecase.recipe.manager.filter;

import recipe.foodbar.entities.Cuisine;

public class CuisineFilterData {
    private Cuisine cuisine;

    public CuisineFilterData(Cuisine cuisine) {
        this.cuisine = cuisine;
    }

    public Cuisine getCuisine() {
        return this.cuisine;
    }
}
