package recipe.foodbar.usecase;

import recipe.foodbar.entities.RegisteredUser;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryInterface {


    static RegisteredUser create(RegisteredUser user) {
        return null;
    }

    static Optional<RegisteredUser> findById(String id) {
        return null;
    }

    static Optional<RegisteredUser> findByEmail(String email) {
        return null;
    }

    static List<RegisteredUser> findAllUsers() {
        return null;
    }

    public static boolean existsByUsername(String username) {
        return false;
    }

}
