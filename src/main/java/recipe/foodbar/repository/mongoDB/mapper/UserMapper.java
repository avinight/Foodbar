package recipe.foodbar.repository.mongoDB.mapper;

import lombok.NonNull;
import org.bson.types.ObjectId;
import recipe.foodbar.entities.User;
import recipe.foodbar.repository.mongoDB.model.UserModel;

public class UserMapper {

    @NonNull
    public static User toEntity(UserModel userModel) {
        return new User(userModel.getId().toHexString(), userModel.getUsername(), userModel.getPassword(), userModel.getFirstName(), userModel.getLastName(), userModel.getEmail());
    }

    @NonNull
    public static UserModel toUserModel(User user) {
        return new UserModel(new ObjectId(user.getId()), user.getUsername(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getFollowing(), user.getFollowers());
    }
}
