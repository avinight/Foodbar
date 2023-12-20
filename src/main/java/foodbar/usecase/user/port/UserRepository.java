/*
The interface laying in the usecase layer that allows the usecase layer to interact with the repository
 */
package foodbar.usecase.user.port;

import foodbar.entities.User;

import java.util.ArrayList;
import java.util.Optional;

public interface UserRepository {


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
     * @param Id the String representation of the username
     * @return to be implemented by classes which implement the interface.
     */
    Optional<User> findById(String Id);

    /**
     * Abstract method for finding all users in the repository
     *
     * @return to be implemented by classes which implement the interface.
     */
    ArrayList<User> findAllUsers();

    /**
     * Update the user object after one of its attributes has been answered
     * @param user The user object that needs to be udpated
     * @return the user object that was updated
     */
    User update(User user);

    /**
     * Abstract method for finding if a user exists by their username
     *
     * @param username the String representation of the username
     * @return to be implemented by classes which implement the interface.
     */
    boolean existsByUsername(String username);
}
