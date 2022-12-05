package recipe.foodbar.repository.mongoDB.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import recipe.foodbar.entities.User;

import java.util.ArrayList;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserModel {
    private ObjectId id;
    private String username;
    private String password;
    private String email;
    private ArrayList<User> following;
    private ArrayList<User> followers;
}
