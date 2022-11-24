package recipe.foodbar.usecase.recipe.port;

import recipe.foodbar.entities.Cuisine;
import recipe.foodbar.entities.Recipe.Recipe;

import java.util.ArrayList;

public interface RecipeRepository {

    ArrayList<Recipe> getAllRecipes();

    Recipe create(Recipe recipe);

    Recipe update(Recipe recipe);

    ArrayList<Recipe> getByCuisine(Cuisine cuisine);

    Recipe findById(final String id);
}
