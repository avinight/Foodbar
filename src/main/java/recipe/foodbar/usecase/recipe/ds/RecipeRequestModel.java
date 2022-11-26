package recipe.foodbar.usecase.recipe.ds;

import lombok.Data;
import recipe.foodbar.entities.Cuisine.Cuisine;
import recipe.foodbar.entities.Ingredient.Ingredient;


import java.util.ArrayList;

@Data
public record RecipeRequestModel(String _id, String title, String[] instructions, Cuisine cuisine,
                                 String[] dietaryRestrictions, float portionSize, ArrayList<Ingredient> ingredients) {
}
