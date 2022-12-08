package recipe.foodbar.usecase.userLogin;

import recipe.foodbar.entities.User;
import recipe.foodbar.usecase.user.port.UserRepository;

import java.util.Objects;
import java.util.Optional;

public class UserLoginValidator {

    private final UserRepository repo;

    public UserLoginValidator(UserRepository repo) {
        this.repo = repo;
    }

    /**
     * Validation check of whether the entries are left null
     *
     * @param username String representation of the username
     * @param password String representation of the password
     * @return boolean value whether it is valid or not
     */
    public boolean fullEntries(String username, String password) {
        return !Objects.equals(username, null) && !Objects.equals(password, null);
    }

    /**
     * Validation check for whether the user exists in the repository searching with username
     *
     * @param username String representation of the username
     * @return boolean value of whether it exists or not
     */

    public boolean validateExist(String username) {
        return (repo.existsByUsername(username));

    }

    /**
     * Validation check for whether the password matches the user
     *
     * @param username String representation of the username
     * @param password String representation of the password
     * @return boolean value of whether it matches or not
     */

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
