package recipe.foodbar.controller.recipe;

import recipe.foodbar.usecase.recipe.manager.factory.CreateRecipe;

public class RecipeController {

    private final CreateRecipe createRecipe;

    public RecipeController(final CreateRecipe createRecipe) {
        this.createRecipe = createRecipe;
    }
    //create, get, all, showByCuisine, getByFollowing
}
