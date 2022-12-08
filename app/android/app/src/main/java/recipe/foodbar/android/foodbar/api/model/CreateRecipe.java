package recipe.foodbar.android.foodbar.api.model;

import java.util.ArrayList;

public class CreateRecipe {
    public String title;
    public float portionSize;
    public ArrayList<String> instructions;
    public String cuisine;
    public ArrayList<String> dietaryRestrictions;
    public ArrayList<Ingredient> ingredients;

    public CreateRecipe(String title, float portionSize, ArrayList<String> instructions, String cuisine, ArrayList<String> dietaryRestrictions, ArrayList<Ingredient> ingredients) {
        this.title = title;
        this.portionSize = portionSize;
        this.instructions = instructions;
        this.cuisine = cuisine;
        this.dietaryRestrictions = dietaryRestrictions;
        this.ingredients = ingredients;
    }
}
