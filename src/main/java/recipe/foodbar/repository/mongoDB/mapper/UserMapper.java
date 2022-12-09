package recipe.foodbar.repository.mongoDB.mapper;

import lombok.NonNull;
import org.bson.types.ObjectId;
import recipe.foodbar.entities.User;
import recipe.foodbar.repository.mongoDB.model.UserModel;

/**
 * Responsible for mapping between User Entity and User Input Object for DB
 */
public class UserMapper {

    @NonNull
    public static User toEntity(UserModel userModel) {
        return new User(userModel.getId().toHexString(), userModel.getUsername(), userModel.getPassword(), userModel.getEmail(), userModel.getFollowing(), userModel.getFollowers(), userModel.getSavedRecipes());
    }

    @NonNull
    public static UserModel toUserModel(User user) {
        return new UserModel(new ObjectId(user.getId()), user.getUsername(), user.getPassword(), user.getEmail(), user.getFollowing(), user.getFollowers(), user.getSavedRecipes());
    }
}
