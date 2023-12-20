/*
A data structure that indicates the recipe to be saved
 */

package foodbar.usecase.user;

import foodbar.entities.Recipe;
import foodbar.entities.User;

public class SaveRecipeData {
    private final Recipe recipeToBeSaved;
    private final User userSaver;

    /**
     * Constructor for SaveRecipeData to be combined with SaveRecipeInteractor (use case interactor)
     *
     * @param recipeGiven The recipe passed in to be saved
     */

    public SaveRecipeData(User saver, Recipe recipeGiven) {
        this.userSaver = saver;
        this.recipeToBeSaved = recipeGiven;
    }

    public Recipe getRecipeToBeSaved() {
        return this.recipeToBeSaved;
    }

    public User getUserSaver() {
        return this.userSaver;
    }
}
