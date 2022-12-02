package recipe.foodbar.controller.recipe;

import recipe.foodbar.entities.Cuisine;
import recipe.foodbar.repository.mongo.model.RecipeModel;
import recipe.foodbar.usecase.recipe.manager.filter.CuisineFilterData;
import recipe.foodbar.usecase.recipe.manager.filter.CuisineFilterInputBoundary;

/**
 * A controller to filter recipes.
 */
public class FilterRecipes {
    public final CuisineFilterInputBoundary f;

    /**
     * Constructor for FilterRecipes
     *
     * @param f
     */
    public FilterRecipes(CuisineFilterInputBoundary f) {
        this.f = f;
    }

    /**
     * Creates and returns Cuisine input data
     * @param cuisine
     * @return
     */
    public CuisineFilterData data(Cuisine cuisine) {
        return new CuisineFilterData(cuisine);
    }


}
