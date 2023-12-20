package foodbar.repository.mongoDB.model;

import foodbar.entities.Recipe;
import foodbar.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

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
