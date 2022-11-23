package recipe.foodbar.usecase.recipe.edit;

import recipe.foodbar.usecase.recipe.RecipeRequestModel;

/**
 * An input boundary for Editing Recipes.
 */
public interface RecipeEditor extends Editor {

    /**
     * Edit the portion size of a recipe.
     *
     * @param rrm The request to edit.
     */
    void editPortionSize(RecipeRequestModel rrm);
}
