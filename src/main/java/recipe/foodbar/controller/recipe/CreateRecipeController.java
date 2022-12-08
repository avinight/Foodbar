package recipe.foodbar.controller.recipe;

import recipe.foodbar.entities.Ingredient;
import recipe.foodbar.usecase.recipe.manager.CreateRecipeInputBoundary;
import recipe.foodbar.usecase.recipe.manager.RecipeInputData;

import java.util.ArrayList;

public class CreateRecipeController {

    public final CreateRecipeInputBoundary data;

    public CreateRecipeController(CreateRecipeInputBoundary inputBoundary) {
        this.data = inputBoundary;
    }

//    public RecipeInputData createRecipe(String title, String userId, float portionSize, ArrayList<String> instructions, String cuisine, ArrayList<String> dietaryRestrictions, ArrayList<Ingredient> ingredients) {
//        return new RecipeInputData(title, userId, portionSize, instructions, cuisine, dietaryRestrictions, ingredients);
//    }

    public String createRecipe(String title, String userId, float portionSize, ArrayList<String> instructions,
                               String cuisine, ArrayList<String> dietaryRestrictions, ArrayList<Ingredient> ingredients) {
        RecipeInputData recipeData = new RecipeInputData(title, userId, portionSize, instructions, cuisine, dietaryRestrictions, ingredients);

        return data.create(recipeData);
    }
}
