package foodbar.usecase.recipe.manager.edit;

import foodbar.repository.mongoDB.model.RecipeModel;

/**
 * An input boundary for editing recipes.
 */
public interface IRecipeEditor extends Editor {

    /**
     * Edit the portion size of a recipe.
     *
     * @param rm The request to edit.
     */
    void editPortionSize(RecipeModel rm);

    void editTitle(RecipeModel rm);

    void editCuisine(RecipeModel rm);

    void editDietaryRestrictions(RecipeModel rm);

    boolean editIngredients(RecipeModel rm);
}
