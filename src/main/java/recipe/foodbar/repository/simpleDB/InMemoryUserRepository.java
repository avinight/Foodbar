/*
The in memory repository which implements the UserRepositoryInterface
 */
package recipe.foodbar.repository.simpleDB;

import recipe.foodbar.entities.User;
import recipe.foodbar.usecase.user.port.UserRepository;

import java.util.*;

public class InMemoryUserRepository implements UserRepository {

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

    /**
     * Abstract method for finding a user by their username in the repository
     *
     * @param username the String representation of the username
     * @return to be implemented by classes which implement the interface.
     */
    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.empty();
    }

    /**
     * Method for finding a user by their username in the repository
     *
     * @param id the String representation of the id
     * @return The RegisteredUser Object of the user found, or an empty
     * user object if no user was found.
     */
    @Override
    public Optional<User> findById(final String id) {
        System.out.println(inMemoryDb.get(id));
        return Optional.ofNullable(inMemoryDb.get(id));
    }


//    /**
//     * Method for getting the password of the matchingusername in repository
//     *
//     * @param username the String representation of the username to be checked in the repository
//     * @return the password of the matching user object
//     */
//    @Override
//    public String getPassword(final String username){
//        return inMemoryDb.get(username).getPassword();
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
     * Update the user object after one of its attributes has been answered
     *
     * @param user The user object that needs to be udpated
     * @return the user object that was updated
     */
    @Override
    public User update(User user) {
        return null;
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
     * Method for returning a user if they exist by their username
     *
     * @param username the String representation of the username
     * @return user object if it exists, empty user otherwise
     */
//    @Override
//    public Optional<User> getByUsername(String username) {
//        Collection<User> userCollection = inMemoryDb.values();
//        for (User user : userCollection) {
//            if (user.getUsername().equals(username)) {
//                return Optional.of(user);
//            }
//        }
//        return Optional.empty();
//    }
//
}
