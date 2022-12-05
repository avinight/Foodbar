package recipe.foodbar.usecase.recipe.manager;

import recipe.foodbar.usecase.recipe.RecipeInputData;

public interface CreateRecipeInputBoundary {
    String create(RecipeInputData input);
}
