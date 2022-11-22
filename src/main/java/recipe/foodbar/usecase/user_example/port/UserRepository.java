package recipe.foodbar.usecase.user_example.port;

import recipe.foodbar.entities.UserExample;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    UserExample create(UserExample userExample);

    Optional<UserExample> findById(String id);

    Optional<UserExample> findByEmail(String email);

    List<UserExample> findAllUsers();
}
