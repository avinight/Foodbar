package recipe.foodbar.repository.mongoDB.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import recipe.foodbar.entities.Recipe;
import recipe.foodbar.entities.User;

import java.util.ArrayList;

/**
 * UserModel used as an input object to MongoDB
 */
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class UserModel {
    private ObjectId id;
    private String username;
    private String password;
    private String email;
    @Builder.Default
    private ArrayList<User> following = new ArrayList<>();
    @Builder.Default
    private ArrayList<User> followers = new ArrayList<>();
    @Builder.Default
    private ArrayList<Recipe> savedRecipes = new ArrayList<Recipe>();
}
