package recipe.foodbar.usecase;

import recipe.foodbar.entities.RegisteredUser;

import java.util.*;

public class InMemoryUserRepository implements UserRepositoryInterface {

    private static final Map<String, RegisteredUser> inMemoryDb = new HashMap<>();


    public static RegisteredUser create(final RegisteredUser user) {
        inMemoryDb.put(user.getUsername(), user);
        return user;
    }

    public static Optional<RegisteredUser> findByUsername(final String username) {
        return Optional.ofNullable(inMemoryDb.get(username));
    }


    public Optional<RegisteredUser> findByEmail(final String email) {
        return inMemoryDb.values().stream()
                .filter(user -> user.getEmail().equals(email))
                .findAny();
    }

    public static ArrayList<RegisteredUser> findAllUsers() {
        return new ArrayList<>(inMemoryDb.values());
    }


    public static boolean existsByUsername(String username) {
        Collection<RegisteredUser> userCollection = inMemoryDb.values();
        for (RegisteredUser user : userCollection){
            if (user.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }
}
