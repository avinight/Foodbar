package recipes.foodbar.usecase.user.port;

import recipes.foodbar.entities.Recipe;

public interface RecipeRepository {
    Recipe create(Recipe recipe);
}
