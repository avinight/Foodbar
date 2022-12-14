package recipe.foodbar.usecase.recipe.manager.filter;

import recipe.foodbar.entities.Recipe;

import java.util.ArrayList;

/*Output boundary interface to allow upwards communication of filtered recipes
  without dependency
*/

public interface CuisineFilterOutputBoundary {
    /**
     * Method signature to present the list of filted recipes
     *
     * @param recipes The filtered recipes
     */
    ArrayList<Recipe> presentFilteredRecipes(ArrayList<Recipe> recipes);
}
