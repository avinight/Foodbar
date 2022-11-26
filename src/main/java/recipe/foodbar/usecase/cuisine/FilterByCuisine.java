package recipe.foodbar.usecase.cuisine;

import recipe.foodbar.entities.Cuisine;
import recipe.foodbar.entities.Recipe.Recipe;
import recipe.foodbar.usecase.recipe.port.RecipeRepository;

import java.util.ArrayList;


public final class FilterByCuisine {

    private final RecipeRepository repository;

    public FilterByCuisine(final RecipeRepository repository) {
        this.repository = repository;
    }

    public ArrayList<Recipe> filterRecipe(Cuisine cuisine) {
        return repository.getByCuisine(cuisine);
    }
}
