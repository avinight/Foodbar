package recipe.foodbar.usecase.recipe.port;

import recipe.foodbar.entities.Cuisine;
import recipe.foodbar.entities.Recipe;

import java.util.ArrayList;
import java.util.Optional;

public interface RecipeRepository {

    ArrayList<Recipe> getAllRecipes();

    Recipe create(Recipe recipe);

    Recipe update(Recipe recipe);

    ArrayList<Recipe> getByCuisine(Cuisine cuisine);

    Optional<Recipe> findById(final String id);
}
