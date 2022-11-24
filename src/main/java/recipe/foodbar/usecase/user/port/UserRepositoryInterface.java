/*
The interface laying in the usecase layer that allows the usecase layer to interact with the repository
 */
package recipe.foodbar.usecase.user.port;

import recipe.foodbar.entities.Recipe;
import recipe.foodbar.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface UserRepositoryInterface {


    /**
     * Abstract method for using creation
     *
     * @param user the provided RegisteredUser object
     */
    void create(User user);

    /**
     * Abstract method for finding a user by their username in the repository
     *
     * @param username the String representation of the username
     * @return to be implemented by classes which implement the interface.
     */
    Optional<User> findByUsername(String username);

    /**
     * Abstract method for finding a user by their email in the repository
     *
     * @param email the String representation of the username
     * @return to be implemented by classes which implement the interface.
     */
    Optional<User> findByEmail(String email);

    /**
     * Abstract method for finding a user by their ID in the repository
     *
     * @param ID the String representation of the username
     * @return to be implemented by classes which implement the interface.
     */
    Optional<User> findByID(String ID);

    /**
     * Abstract method for finding all users in the repository
     *
     * @return to be implemented by classes which implement the interface.
     */
    ArrayList<User> findAllUsers();

    /**
     * Abstract method for finding if a user exists by their username
     *
     * @param username the String representation of the username
     * @return to be implemented by classes which implement the interface.
     */
    boolean existsByUsername(String username);

    void saveRecipe(Recipe recipe);

    void unsaveRecipe(Recipe recipe);

}
