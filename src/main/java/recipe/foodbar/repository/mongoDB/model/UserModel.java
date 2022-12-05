package recipe.foodbar.repository.mongoDB.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import recipe.foodbar.entities.User;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    private ObjectId id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private ArrayList<User> following;
    private ArrayList<User> followers;
}
