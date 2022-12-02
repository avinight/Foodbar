package recipe.foodbar.repository.mongo.model;

import lombok.Data;
import recipe.foodbar.entities.Cuisine;
import recipe.foodbar.entities.Ingredient;
import recipe.foodbar.entities.Review;
import recipe.foodbar.entities.User;

import java.util.ArrayList;
import java.util.Date;

@Data
public class RecipeModel {
    private final String _id;
    private final String title;
    private final String userID;
    private final float portionSize;
    private final String[] instructions;
    private final Cuisine cuisine;
    private final String[] dietaryRestrictions;
    private final Date dateCreated;
    private final ArrayList<Ingredient> ingredients;
    private final ArrayList<String> likers;
    private final ArrayList<String> dislikers;
    private final ArrayList<Review> reviews;
}
