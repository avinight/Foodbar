package recipe.foodbar.controller.recipe;

import recipe.foodbar.repository.mongoDB.model.RecipeModel;
import recipe.foodbar.usecase.recipe.manager.edit.IRecipeEditor;

/**
 * A controller to edit a recipe.
 */
public class EditRecipe {
    private final RecipeModel rm;
    private final IRecipeEditor e;

    /**
     * Constructor for EditRecipe
     *
     * @param rm request to edit.
     * @param e  An editor interface.
     */
    public EditRecipe(RecipeModel rm, IRecipeEditor e) {
        this.rm = rm;
        this.e = e;

    }

    /**
     * Edits the portion size of a recipe.
     */
    public void edit() {
        e.editTitle(this.rm);
        e.editPortionSize(this.rm);
        e.editCuisine(this.rm);
        e.editDietaryRestrictions(this.rm);
        e.editIngredients(this.rm);
    }
}
