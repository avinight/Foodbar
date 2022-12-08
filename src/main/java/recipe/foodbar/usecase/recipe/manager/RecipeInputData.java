package recipe.foodbar.usecase.recipe.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import recipe.foodbar.entities.Cuisine;
import recipe.foodbar.entities.Ingredient;

import java.util.ArrayList;

@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
public class RecipeInputData {
    public String title;
    public String userId;
    public float portionSize;
    public ArrayList<String> instructions;
    public String cuisine;
    public ArrayList<String> dietaryRestrictions;
    public ArrayList<Ingredient> ingredients;
}
