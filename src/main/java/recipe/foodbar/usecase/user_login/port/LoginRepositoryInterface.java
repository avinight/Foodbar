package recipe.foodbar.usecase.user_login.port;

import recipe.foodbar.entities.User;

import java.util.ArrayList;
import java.util.Optional;

public interface LoginRepositoryInterface {

    void add(final User user, final String cookie);


    Optional<User> findByCookie(final String cookie);

    ArrayList<User> findAllActive();


    Optional<User> findByUsername(String username);

    void remove(String cookie);
}
