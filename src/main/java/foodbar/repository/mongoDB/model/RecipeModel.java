package foodbar.repository.mongoDB.model;

import foodbar.entities.Review;
import foodbar.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import recipe.foodbar.entities.Cuisine;
import recipe.foodbar.entities.Ingredient;

import java.util.ArrayList;
import java.util.Date;
/**
 * Recipe used as an input object to MongoDB
 */
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class RecipeModel {
    private ObjectId id;
    private String title;
    private User user;
    private ArrayList<String> instructions;
    private Cuisine cuisine;
    private ArrayList<String> dietaryRestrictions;
    private Date dateCreated;
    private float portionSize;
    @Builder.Default
    private ArrayList<Review> reviews = new ArrayList<>();
    @Builder.Default
    private ArrayList<Ingredient> ingredients = new ArrayList<>();
    @Builder.Default
    private ArrayList<String> likers = new ArrayList<>();
    @Builder.Default
    private ArrayList<String> dislikers = new ArrayList<>();
}
