package recipe.foodbar.repository.mongo.mapper;

import lombok.NonNull;
import recipe.foodbar.entities.User;
import recipe.foodbar.repository.mongo.model.UserModel;

public class UserMapper {

    @NonNull
    public static User toEntity(UserModel userModel) {
        return new User(userModel.get_id(), userModel.getUsername(), userModel.getPassword(), userModel.getFirstName(), userModel.getLastName(), userModel.getEmail());
    }

    @NonNull
    public static UserModel toUserModel(User user) {
        return new UserModel(user.getId(), user.getUsername(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getEmail());
    }
}
