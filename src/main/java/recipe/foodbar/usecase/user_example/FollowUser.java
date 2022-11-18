package recipe.foodbar.usecase.user_example;

import recipe.foodbar.usecase.user_example.port.UserRepository;
import recipe.foodbar.entities.User;

import java.util.NoSuchElementException;
import java.util.Optional;

public class FollowUser {

    private UserRepository repository;

    public FollowUser(UserRepository repository) { this.repository = repository; }

    public boolean follow(String userId1, String userId2) {
        Optional<User> followingUser = repository.findById(userId1);
        Optional<User> followedUser = repository.findById(userId2);
        try {
            followingUser.get().follow(followedUser.get());
            return true;
        } catch (NoSuchElementException nse) {
            return false;
        }
    }

}
