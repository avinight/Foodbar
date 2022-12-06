package recipe.foodbar.usecase.user_login;

import recipe.foodbar.usecase.user.port.UserRepositoryInterface;

import java.util.Objects;

public class UserLoginValidator {

    private final UserRepositoryInterface repo;

    public UserLoginValidator(UserRepositoryInterface repo) {
        this.repo = repo;
    }

    public boolean fullEntries(String username, String password) {
        return !Objects.equals(username, "") && !Objects.equals(password, "");
    }

    public boolean validateExist(String username) {
        return (repo.existsByUsername(username));
    }

    public boolean validatePassword(String username, String password) {
        return repo.findByUsername(username).filter(user -> user.getPassword().equals(password)).isPresent();
    }
}
