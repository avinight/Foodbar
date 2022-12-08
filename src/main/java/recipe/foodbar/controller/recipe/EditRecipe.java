package recipe.foodbar.controller.recipe;

import recipe.foodbar.usecase.recipe.ds.RecipeRequestModel;
import recipe.foodbar.usecase.recipe.manager.edit.IRecipeEditor;

/**
 * A controller to edit a recipe.
 */
public class EditRecipe {
    private final RecipeRequestModel rm;
    private final IRecipeEditor e;

    /**
     * Constructor for EditRecipe
     *
     * @param rm request to edit.
     * @param e   An editor interface.
     */
    public EditRecipe(RecipeRequestModel rm, IRecipeEditor e) {
        this.rm = rm;
        this.e = e;

    }

    /**
     * Edits this recipe.
     */
    public void edit() {
        e.editTitle(this.rm);
        e.editPortionSize(this.rm);
        e.editCuisine(this.rm);
        e.editDietaryRestrictions(this.rm);
        e.editIngredients(this.rm);
    }
}
