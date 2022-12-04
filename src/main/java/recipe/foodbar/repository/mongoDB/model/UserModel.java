package recipe.foodbar.repository.mongoDB.model;

import lombok.Data;
import org.bson.types.ObjectId;
import recipe.foodbar.entities.User;

import java.util.ArrayList;

@Data
public class UserModel {
    private final ObjectId _id;
    private final String username;
    private final String password;
    private final String firstName;
    private final String lastName;
    private final String email;
    private ArrayList<User> following;
    private ArrayList<User> followers;
}
