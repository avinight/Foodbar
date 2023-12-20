/*
Input Boundary interface for the SaveRecipeInteractor
 */

package foodbar.usecase.user;

public interface SaveRecipeInputBoundary {

    /**
     * Abstract save recipe method to be implemented by the SaveRecipeInteractor
     *
     * @param inputDS the SaveRecipeData which contains the user that wants to save the recipe and the recipe object
     *                they want to save
     * @return The return type of the presenter interface i.e. string denoting success or failure of saving recipe
     */
    String saveRecipe(SaveRecipeData inputDS);

    /**
     * @param inputDS the recipe data object to be unsaved from the user's list of savedRecipes
     * @return the return type of the presenter interface i.e.e string denoting success or failure of unsaving recipe
     */

    String unsaveRecipe(SaveRecipeData inputDS);
}
