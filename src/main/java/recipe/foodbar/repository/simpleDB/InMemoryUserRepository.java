package recipe.foodbar.repository.simpleDB;

import recipe.foodbar.entities.UserExample;
import recipe.foodbar.usecase.user_example.port.UserRepository;

import java.util.*;

public class InMemoryUserRepository implements UserRepository {

    private final Map<String, UserExample> inMemoryDb = new HashMap<>();

    @Override
    public UserExample create(final UserExample userExample) {
        inMemoryDb.put(userExample.getId(), userExample);
        return userExample;
    }

    @Override
    public Optional<UserExample> findById(final String id) {
        return Optional.ofNullable(inMemoryDb.get(id));
    }

    @Override
    public Optional<UserExample> findByEmail(final String email) {
        return inMemoryDb.values().stream()
                .filter(user -> user.getEmail().equals(email))
                .findAny();
    }

    @Override
    public List<UserExample> findAllUsers() {
        return new ArrayList<>(inMemoryDb.values());
    }
}