package recipe.foodbar.usecase.userLogin;

import recipe.foodbar.entities.User;
import recipe.foodbar.usecase.user.port.UserRepositoryInterface;

import java.util.Objects;
import java.util.Optional;

public class UserLoginValidator {

    private final UserRepositoryInterface repo;

    public UserLoginValidator(UserRepositoryInterface repo) {
        this.repo = repo;
    }

    public boolean fullEntries(String username, String password) {
        return !Objects.equals(username, null) && !Objects.equals(password, null);
    }

    public boolean validateExist(String username) {
        return (repo.existsByUsername(username));

    }

    public boolean validatePassword(String username, String password) {
        //interactor already checks if user.isEmpty()
        //code purpose is to satisfy java warnings
        Optional<User> user = repo.findByUsername(username);
        if (user.isEmpty()) {
            return false;
        }
        String pass = user.get().getPassword();
        return password.equals(pass);
    }
}
