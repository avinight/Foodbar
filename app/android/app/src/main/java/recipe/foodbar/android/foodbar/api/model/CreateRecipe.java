package recipe.foodbar.android.foodbar.api.model;

import java.util.ArrayList;

public class CreateRecipe {
    public String title;
    public float portionSize;
    public ArrayList<String> instructions;
    public String cuisine;
    public ArrayList<String> dietaryRestrictions;
    public ArrayList<Ingredient> ingredients;
}
