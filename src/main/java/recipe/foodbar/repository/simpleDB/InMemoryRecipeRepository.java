package recipe.foodbar.repository.simpleDB;

import recipe.foodbar.entities.Cuisine.Cuisine;
import recipe.foodbar.entities.Recipe.Recipe;
import recipe.foodbar.usecase.recipe.port.RecipeRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryRecipeRepository implements RecipeRepository {

    private final Map<String, Recipe> inMemoryDb = new HashMap<>();

    @Override
    public ArrayList<Recipe> getAllRecipes() {
        return new ArrayList<>(this.inMemoryDb.values());
    }

    @Override
    public Recipe create(final Recipe recipe) {
        inMemoryDb.put(recipe.getId(), recipe);
        return recipe;
    }

    @Override
    public ArrayList<Recipe> getByCuisine(Cuisine cuisine) {
        ArrayList<Recipe> filteredRecipes = new ArrayList<Recipe>();
        for (Recipe recipe : this.inMemoryDb.values()) {
            if (recipe.getCuisine().equals(cuisine.getId())) {
                filteredRecipes.add(recipe);
            }
        }
        return filteredRecipes;
    }

    @Override
    public Recipe update(final Recipe recipe) {
        inMemoryDb.remove(recipe.getId());
        return create(recipe);
    }

    public Optional<Recipe> findById(final String id) {
        return Optional.ofNullable(inMemoryDb.get(id));
    }

}

