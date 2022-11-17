/*
The in memory repository which implements the UserRepositoryInterface
 */
package recipe.foodbar.repository;

import recipe.foodbar.entities.RegisteredUser;
import recipe.foodbar.usecase.UserRepositoryInterface;

import java.util.*;

public class InMemoryUserRepository implements UserRepositoryInterface {

    private final Map<String, RegisteredUser> inMemoryDb = new HashMap<>();


    /**
     * Method for adding the Registered user object to the repository.
     *
     * @param user the provided RegisteredUser object
     *
     */
    @Override
    public void create(final RegisteredUser user) {
        inMemoryDb.put(user.getUsername(), user);
    }

    /**
     * Method for finding a user by their username in the repository
     * @param username the String representation of the username
     * @return The RegisteredUser Object of the user found, or an empty
     * user object if no user was found.
     */
    @Override
    public Optional<RegisteredUser> findByUsername(final String username) {
        return Optional.ofNullable(inMemoryDb.get(username));
    }

    /**
     * Method for finding a user by their email in the repository
     * @param email the String representation of the username
     * @return The RegisteredUser object with the matching email provided.
     */
    @Override
    public Optional<RegisteredUser> findByEmail(final String email) {
        return inMemoryDb.values().stream()
                .filter(user -> user.getEmail().equals(email))
                .findAny();
    }


    /**
     * Method for finding all users in the repository
     * @return An ArrayList of all users in the repository.
     */
    @Override
    public ArrayList<RegisteredUser> findAllUsers() {
        return new ArrayList<>(inMemoryDb.values());
    }


    /**
     * Method for finding if a user exists by their username
     * @param username the String representation of the username
     * @return boolean representation of the existence of a RegisteredUser
     * with a matching username.
     */
    @Override
    public boolean existsByUsername(String username) {
        Collection<RegisteredUser> userCollection = inMemoryDb.values();
        for (RegisteredUser user : userCollection){
            if (user.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }
}
