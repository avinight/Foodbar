package recipe.foodbar.repository.simpleDB;

import recipe.foodbar.entities.Cuisine;
import recipe.foodbar.entities.Recipe;
import recipe.foodbar.usecase.recipe.port.RecipeRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryRecipeRepository implements RecipeRepository {

    private final Map<String, Recipe> inMemoryDb = new HashMap<>();

    @Override
    public Recipe create(final Recipe recipe) {
        inMemoryDb.put(recipe.getId(), recipe);
        return recipe;
    }

    @Override
    public ArrayList<Recipe> getByCuisine(Cuisine cuisine) {
        ArrayList<Recipe> filteredRecipes = new ArrayList<Recipe>();
        for (Recipe recipe : this.inMemoryDb.values()) {
            if (recipe.getCuisineId().equals(cuisine.getId())) {
                filteredRecipes.add(recipe);
            }
        }
        return filteredRecipes;
    }

    public Optional<Recipe> findById(final String id) {
        return Optional.ofNullable(inMemoryDb.get(id));
    }

}

