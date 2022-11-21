package recipe.foodbar.usecase.user_example;

import recipe.foodbar.entities.UserExample;
import recipe.foodbar.usecase.user_example.port.UserRepository;

import java.util.List;
import java.util.Optional;

public final class FindUser {

    private final UserRepository repository;

    public FindUser(final UserRepository repository) {
        this.repository = repository;
    }

    public Optional<UserExample> findById(final String id) {
        return repository.findById(id);
    }

    public List<UserExample> findAllUsers() {
        return repository.findAllUsers();
    }
}
