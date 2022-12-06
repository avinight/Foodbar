package recipe.foodbar.repository.simpleDB;

import recipe.foodbar.entities.User;
import recipe.foodbar.usecase.userLogin.port.LoginRepositoryInterface;

import java.util.*;


public class InMemoryCookieRepository implements LoginRepositoryInterface {

    private final Map<String, User> inMemoryDb = new HashMap<>();

    @Override
    public void add(final User user, final String cookie) {
        inMemoryDb.put(cookie, user);
    }


    @Override
    public Optional<User> findByCookie(final String cookie) {
        return Optional.ofNullable(inMemoryDb.get(cookie));
    }

    @Override
    public ArrayList<User> findAllActive() {
        return new ArrayList<>(inMemoryDb.values());
    }

    @Override
    public Optional<User> findByUsername(final String username) {
        Collection<User> userCollection = inMemoryDb.values();
        for (User user : userCollection) {
            if (user.getUsername().equals(username)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();

    }

    @Override
    public void remove(final String cookie) {
        Optional<User> user = findByCookie(cookie);
        if (user.isPresent()) {
            inMemoryDb.remove(cookie, user);


        }


    }
}

