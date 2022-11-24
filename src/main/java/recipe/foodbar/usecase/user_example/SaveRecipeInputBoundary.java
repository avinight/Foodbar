/*
Input Boundary interface for the SaveRecipeInteractor
 */

package recipe.foodbar.usecase.user_example;

import recipe.foodbar.entities.Recipe;
import recipe.foodbar.entities.User;

public interface SaveRecipeInputBoundary {

    /**
     * Abstract save recipe method to be implemented by the SaveRecipeInteractor
     * @param inputDS the SaveRecipeData which contains the user that wants to save the recipe and the recipe object
     *                they want to save
     * @return The return type of the presenter interface i.e. string denoting success or failure of saving and
     *          un-saving a recipe
     */
     String saveRecipe(SaveRecipeData inputDS);
     }
