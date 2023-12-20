package foodbar.presenter;

import foodbar.entities.Recipe;
import foodbar.usecase.recipe.manager.filter.CuisineFilterOutputBoundary;

import java.util.ArrayList;

/* Presenter class for recipes filtered by a cuisine
 */

public class CuisineFilterPresenter implements CuisineFilterOutputBoundary {

    /**
     * Method which prints the filter recipes (look at Recipe.toString to see their string representation)
     *
     * @param recipes The filtered recipes
     **/
    @Override
    public ArrayList<Recipe> presentFilteredRecipes(ArrayList<Recipe> recipes) {
        return recipes;
    }
}
