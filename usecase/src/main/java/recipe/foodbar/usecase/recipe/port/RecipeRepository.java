package recipe.foodbar.usecase.recipe.port;

import recipe.foodbar.entities.Recipe;

public interface RecipeRepository {
    Recipe create(Recipe recipe);
}
