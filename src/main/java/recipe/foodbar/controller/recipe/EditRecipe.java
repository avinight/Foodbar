package recipe.foodbar.controller.recipe;

import recipe.foodbar.usecase.recipe.RecipeRequestModel;
import recipe.foodbar.usecase.recipe.edit.RecipeEditor;

/**
 * A controller to edit a recipe.
 */
public class EditRecipe {
    private final RecipeRequestModel rrm;
    private final RecipeEditor e;

    /**
     * Constructor for EditRecipe
     *
     * @param rrm request to edit.
     * @param e   An editor interface.
     */
    public EditRecipe(RecipeRequestModel rrm, RecipeEditor e) {
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
