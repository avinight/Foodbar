package recipe.foodbar.controller.recipe;

import recipe.foodbar.usecase.recipe.manager.CreateRecipeInteractor;

public class RecipeController {

    private final CreateRecipeInteractor createRecipe;

    public RecipeController(final CreateRecipeInteractor createRecipe) {
        this.createRecipe = createRecipe;
    }
    //create, get, all, showByCuisine, getByFollowing
}
