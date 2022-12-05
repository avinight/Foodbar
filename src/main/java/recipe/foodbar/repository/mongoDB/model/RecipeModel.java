package recipe.foodbar.repository.mongoDB.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import recipe.foodbar.entities.Cuisine;
import recipe.foodbar.entities.Ingredient;
import recipe.foodbar.entities.Review;
import recipe.foodbar.entities.User;

import java.util.ArrayList;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeModel {
    private ObjectId id;
    private String title;
    private User author;
    private ArrayList<String> instructions;
    private Cuisine cuisine;
    private ArrayList<String> dietaryRestrictions;
    private Date dateCreated;
    private float portionSize;
    private ArrayList<Review> reviews;
    private ArrayList<Ingredient> ingredients;
    private ArrayList<String> likers;
    private ArrayList<String> dislikers;
}
