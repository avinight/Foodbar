package recipes.foodbar.usecase.user;

import recipes.foodbar.entities.User;
import recipes.foodbar.usecase.user.port.UserRepository;

import java.util.List;
import java.util.Optional;

public final class FindUser {

    private final UserRepository repository;

    public FindUser(final UserRepository repository) {
        this.repository = repository;
    }

    public Optional<User> findById(final String id) {
        return repository.findById(id);
    }

    public List<User> findAllUsers() {
        return repository.findAllUsers();
    }
}
