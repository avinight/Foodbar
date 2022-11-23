package recipe.foodbar.usecase.edit;

import recipe.foodbar.entities.Recipe;
import recipe.foodbar.usecase.recipe.RecipeRequestModel;
import recipe.foodbar.usecase.recipe.port.RecipeRepository;

/**
 * This class is responsible for performing all direct interactions with the Recipe entity class.
 */
public class RecipeEditor implements Editor {
    private final RecipeRequestModel recipe;
    private final RecipeRepository recipeRepo;

    /* TODO: Make this take in request model and output response model and depend on output boundary
     */

    /**
     * Constructor for the RecipeEditor class, initializes a RecipeEditor.
     *
     * @param recipe A recipe object.
     */
    public RecipeEditor(RecipeRepository recipeRepo) {
        this.recipeRepo = recipeRepo;
    }

    /**
     * Edits the portionSize of a Recipe object.
     *
     * @param recipe      The recipe object.
     * @param portionSize The new portion size of a recipe.
     */
    public void editPortionSize(Recipe recipe, int portionSize) {
        /* Must check that the id exists and is valid, otherwise throw an exception*/
        recipe.modifyIngredients(portionSize);
    }

    /**
     * Return the recipe's information
     *
     * @param recipe    The recipe object.
     * @param presenter presenter
     */
    public
}
