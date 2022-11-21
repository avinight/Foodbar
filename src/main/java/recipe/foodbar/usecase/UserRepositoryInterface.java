/*
The interface laying in the usecase layer that allows the usecase layer to interact with the repository
 */
package recipe.foodbar.usecase;

import recipe.foodbar.entities.RegisteredUser;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryInterface {


    /**
     * Abstract method for using creation
     * @param user the provided RegisteredUser object
     *
     */
    void create(RegisteredUser user);

    /**
     * Abstract method for finding a user by their username in the repository
     * @param username the String representation of the username
     * @return to be implemented by classes which implement the interface.
     */
    Optional<RegisteredUser> findByUsername(String username);

    /**
     * Abstract method for finding a user by their email in the repository
     * @param email the String representation of the username
     * @return to be implemented by classes which implement the interface.
     */
    Optional<RegisteredUser> findByEmail(String email);

    /**
     * Abstract method for finding all users in the repository
     * @return to be implemented by classes which implement the interface.
     */
    List<RegisteredUser> findAllUsers();

    /**
     * Abstract method for finding if a user exists by their username
     * @param username the String representation of the username
     * @return to be implemented by classes which implement the interface.
     */
    boolean existsByUsername(String username);

}
