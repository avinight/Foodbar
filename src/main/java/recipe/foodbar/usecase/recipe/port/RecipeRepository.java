package recipe.foodbar.usecase.recipe.port;

import recipe.foodbar.entities.Cuisine;
import recipe.foodbar.entities.Recipe;

import java.util.ArrayList;
import java.util.Optional;

public interface RecipeRepository {

    /**
     * abstract method to return all recipes
     * @return to be implemented by the class implementing this interface
     */
    ArrayList<Recipe> getAllRecipes();

    /**
     * method to create recipe implemented by the db
     * @param recipe recipe to be created
     * @return to be implemented by the class implementing this interface
     */
    Recipe create(Recipe recipe);

    /**
     * method to update recipe implemented by the db
     * @param recipe the recipe to be updated
     * @return to be implemented by the class implementing this interface
     */
    Recipe update(Recipe recipe);

    /** Getter for recipes by cuisine type
     *
     * @param cuisine cuisine to search for
     * @return to be implemented by the class implementing this interface
     */
    ArrayList<Recipe> getByCuisine(Cuisine cuisine);

    /**
     * Getter for recipes by ID
     *
     * @param id recipe id
     * @return to be implemented by the class implementing this interface
     */
    Optional<Recipe> findById(final String id);
}
