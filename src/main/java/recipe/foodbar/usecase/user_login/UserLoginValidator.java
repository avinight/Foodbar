package recipe.foodbar.usecase.user_login;

import recipe.foodbar.entities.User;
import recipe.foodbar.usecase.user.port.UserRepositoryInterface;

import java.util.Objects;

public class UserLoginValidator {

    private final UserRepositoryInterface repo;

    public UserLoginValidator(UserRepositoryInterface repo) {
        this.repo = repo;
    }

    public boolean fullEntries(String username, String password){
        return !Objects.equals(username, "") && !Objects.equals(password, "");
    }
    public boolean validateExist(String username){
        return(repo.existsByUsername(username));

    }

    public boolean validatePassword(String username, String password){
        String repoPassword = repo.getPassword(username);

        return repoPassword.equals(password);

    }


}
