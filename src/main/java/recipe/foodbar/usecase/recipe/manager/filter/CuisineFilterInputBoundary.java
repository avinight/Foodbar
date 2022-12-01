package recipe.foodbar.usecase.recipe.manager.filter;

import recipe.foodbar.entities.Cuisine;
import recipe.foodbar.entities.Recipe.Recipe;
import java.util.ArrayList;

/*interface for usecase interactor*/

public interface CuisineFilterInputBoundary {
    /**
     * Usecase method to be implemented by usecase interactor
     *
     * @param cuisineData CuisineInputData representing desired cuisine
     * @return Arraylist of recipes filtered by cuisineData
     */
    ArrayList<Recipe> filterByCuisine(CuisineFilterData cuisineData);
}