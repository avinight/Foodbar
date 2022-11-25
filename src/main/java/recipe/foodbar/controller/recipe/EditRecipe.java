package recipe.foodbar.controller.recipe;

import recipe.foodbar.usecase.recipe.ds.RecipeRequestModel;
import recipe.foodbar.usecase.recipe.manager.edit.IRecipeEditor;

/**
 * A controller to edit a recipe.
 */
public class EditRecipe {
    private final RecipeRequestModel rrm;
    private final IRecipeEditor e;

    /**
     * Constructor for EditRecipe
     *
     * @param rrm request to edit.
     * @param e   An editor interface.
     */
    public EditRecipe(RecipeRequestModel rrm, IRecipeEditor e) {
        this.rrm = rrm;
        this.e = e;

    }

    /**
     * Edits the portion size of a recipe.
     */
    public void edit() {
        e.editPortionSize(this.rrm);
    }
}
