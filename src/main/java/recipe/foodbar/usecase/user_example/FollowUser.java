package recipe.foodbar.usecase.user_example;

import recipe.foodbar.usecase.user_example.port.UserRepository;
import recipe.foodbar.entities.UserExample;

import java.util.NoSuchElementException;
import java.util.Optional;

public class FollowUser {

    private final UserRepository repository;

    public FollowUser(UserRepository repository) { this.repository = repository; }

    public boolean follow(String userId1, String userId2) {
        Optional<UserExample> followingUser = repository.findById(userId1);
        Optional<UserExample> followedUser = repository.findById(userId2);
        try {
            followingUser.get().follow(followedUser.get());
            return true;
        } catch (NoSuchElementException nse) {
            return false;
        }
    }

}
