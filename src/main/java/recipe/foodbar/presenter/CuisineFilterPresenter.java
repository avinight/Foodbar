package recipe.foodbar.presenter;

import recipe.foodbar.entities.Recipe;
import recipe.foodbar.usecase.recipe.manager.filter.CuisineFilterOutputBoundary;

import java.util.ArrayList;

/* Presenter class for recipes filtered by a cuisine
* */

public class CuisineFilterPresenter implements CuisineFilterOutputBoundary {

    /**
     * Method which prints the filtere recipes (look at Recipe.toString to see their string representation)
     *
     * @param recipes The filtered recipes
     */
    @Override
    public void presentFilteredRecipes(ArrayList<Recipe> recipes) {
        for (Recipe r: recipes) {
            System.out.println(recipes);
        }
    }
}
