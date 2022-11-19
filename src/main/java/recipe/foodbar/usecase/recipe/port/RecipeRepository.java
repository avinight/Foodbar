package recipe.foodbar.usecase.recipe.port;

import recipe.foodbar.entities.Recipe;
import recipe.foodbar.entities.Cuisine;
import java.util.ArrayList;
import java.util.Optional;

public interface RecipeRepository {
    Recipe create(Recipe recipe);

    ArrayList<Recipe> getByCuisine(Cuisine cuisine);
    Optional<Recipe> findById(final String id);
}
