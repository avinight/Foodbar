package foodbar.usecase.userLogin.port;

import foodbar.entities.User;

import java.util.ArrayList;
import java.util.Optional;

/**
 * LoginRepositoryInterface to be implemented by the repository needed
 */
public interface LoginRepositoryInterface {

    /**
     * Method to add a user to the repository
     *
     * @param user User object
     * @param cookie String representing the cookie
     */
    void add(final User user, final String cookie);


    /**
     * Method to find a user by the given cookie
     *
     * @param cookie String representation of the cookie
     * @return result of the search as a boolean
     */
    Optional<User> findByCookie(final String cookie);


    /**
     * Find a list of all logged in users
     * @return ArrayList containing user objects
     */
    ArrayList<User> findAllActive();


    /**
     * Find a user by their username
     *
     * @param username String representation of the username
     * @return return user object if found, empty user object if not found
     */
    Optional<User> findByUsername(String username);


    /**
     * Remove the user corresponding to the cookie from the database
     * @param cookie String representation of the cookie
     */
    void remove(String cookie);
}
