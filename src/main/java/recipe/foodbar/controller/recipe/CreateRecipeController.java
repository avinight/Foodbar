package recipe.foodbar.controller.recipe;

import recipe.foodbar.entities.Ingredient;
import recipe.foodbar.usecase.recipe.manager.CreateRecipeInputBoundary;
import recipe.foodbar.usecase.recipe.manager.RecipeInputData;

import java.util.ArrayList;


public class CreateRecipeController {

    public final CreateRecipeInputBoundary data;

    /**
     * Controller in the interface adapter layer.
     *
     * @param inputBoundary The input boundary
     */
    public CreateRecipeController(CreateRecipeInputBoundary inputBoundary) {
        this.data = inputBoundary;
    }

    /**
     * The method which will create String containing InputData for the recipe.
     *
     * @param title String title of recipe
     * @param userId String user id of author
     * @param portionSize portion size of recipe
     * @param instructions instructions for the recipe
     * @param cuisine Cuisine that this recipe corresponds to
     * @param dietaryRestrictions Dietary restrictions imposed on this recipe
     * @param ingredients The ingredient objects for this recipe
     *
     * @return Completed Recipe Data object
     */
    public String createRecipe(String title, String userId, float portionSize, ArrayList<String> instructions,
                               String cuisine, ArrayList<String> dietaryRestrictions, ArrayList<Ingredient> ingredients) {
        RecipeInputData recipeData = new RecipeInputData(title, userId, portionSize, instructions, cuisine, dietaryRestrictions, ingredients);

        return data.create(recipeData);
    }
}
