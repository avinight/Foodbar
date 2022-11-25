package recipe.foodbar.usecase.recipe.manager.edit;

import recipe.foodbar.usecase.recipe.ds.RecipeRequestModel;

/**
 * An input boundary for editing recipes.
 */
public interface IRecipeEditor extends Editor {

    /**
     * Edit the portion size of a recipe.
     *
     * @param rrm The request to edit.
     */
    void editPortionSize(RecipeRequestModel rrm);
}
