package recipe.foodbar.usecase.recipe.port;

import recipes.foodbar.entities.Recipe;

public interface RecipeRepository {
    Recipe create(Recipe recipe);
}
