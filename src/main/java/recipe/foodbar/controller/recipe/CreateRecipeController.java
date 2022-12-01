package recipe.foodbar.controller.recipe;

import recipe.foodbar.entities.Cuisine;
import recipe.foodbar.entities.Ingredient;
import recipe.foodbar.entities.Review;
import recipe.foodbar.entities.User;
import recipe.foodbar.usecase.recipe.manager.CreateRecipeInputBoundary;
import recipe.foodbar.usecase.recipe.manager.CreateRecipeInteractor;
import recipe.foodbar.usecase.recipe.manager.RecipeInputData;

import java.util.ArrayList;
import java.util.Date;

public class CreateRecipeController {

    public final CreateRecipeInputBoundary inputBoundary;

    public CreateRecipeController(CreateRecipeInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public RecipeInputData createRecipe(String title, final User author, float portionSize, String[] instructions,
                                        Cuisine cuisine, String[] dietaryRestrictions, final Date dateCreated,
                                        ArrayList<Ingredient> ingredients, ArrayList<String> likers, ArrayList<String> dislikers,
                                        ArrayList<Review> reviews) {
        return new RecipeInputData(title, author, portionSize, instructions, cuisine, dietaryRestrictions,
                dateCreated, ingredients, likers, dislikers, reviews);
    }
}
