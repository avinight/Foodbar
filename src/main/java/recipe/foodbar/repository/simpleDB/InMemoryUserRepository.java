/*
The in memory repository which implements the UserRepositoryInterface
 */
package recipe.foodbar.repository.simpleDB;

import recipe.foodbar.entities.User;
import recipe.foodbar.usecase.user.port.UserRepositoryInterface;

import java.util.*;

public class InMemoryUserRepository implements UserRepositoryInterface {

    private final Map<String, User> inMemoryDb = new HashMap<>();


    /**
     * Method for adding the Registered user object to the repository.
     *
     * @param user the provided RegisteredUser object
     */
    @Override
    public void create(final User user) {
        inMemoryDb.put(user.getUsername(), user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        Collection<User> userCollection = inMemoryDb.values();
        for (User user : userCollection) {
            if (user.getUsername().equals(username)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    /**
     * Abstract method for finding a user by their username in the repository
     *
     * @param id the String representation of the id
     * @return to be implemented by classes which implement the interface.
     */
    @Override
    public Optional<User> findById(String id) {
        return Optional.ofNullable(inMemoryDb.get(id));
    }

    /**
     * Abstract method for finding a user by their username in the repository
     *
     * @param id the String representation of the id
     * @return to be implemented by classes which implement the interface.
     */
    @Override
    public Optional<User> findById(String id) {
        return Optional.ofNullable(inMemoryDb.get(id));
    }

    /**
     * Method for finding a user by their username in the repository
     *
     * @param username the String representation of the username
     * @return The RegisteredUser Object of the user found, or an empty
     * user object if no user was found.
     */
//    @Override
//    public Optional<User> findByUsername(final String username) {
//        return Optional.ofNullable(inMemoryDb.get(username));
//    }

    /**
     * Method for finding a user by their email in the repository
     *
     * @param email the String representation of the username
     * @return The RegisteredUser object with the matching email provided.
     */
    @Override
    public Optional<User> findByEmail(final String email) {
        return inMemoryDb.values().stream()
                .filter(user -> user.getEmail().equals(email))
                .findAny();
    }


    /**
     * Method for finding all users in the repository
     *
     * @return An ArrayList of all users in the repository.
     */
    @Override
    public ArrayList<User> findAllUsers() {
        return new ArrayList<>(inMemoryDb.values());
    }


    /**
     * Method for finding if a user exists by their username
     *
     * @param username the String representation of the username
     * @return boolean representation of the existence of a RegisteredUser
     * with a matching username.
     */
    @Override
    public boolean existsByUsername(String username) {
        Collection<User> userCollection = inMemoryDb.values();
        for (User user : userCollection) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Abstract method for getting password
     *
     * @param username the String representation of the username
     * @return to be implemented
     */
    @Override
    public String getPassword(String username) {
        return null;
    }

    @Override
    public Optional<User> getByUsername(String username) {
        return Optional.empty();
    }
}
