package recipe.foodbar.usecase.user_example;

import recipe.foodbar.entities.UserExample;
import recipe.foodbar.usecase.user_example.port.UserRepository;

import java.util.Optional;

public class FollowUnfollowUser {

    private final UserRepository repository;

    public FollowUnfollowUser(UserRepository repository) {
        this.repository = repository;
    }

    public boolean followUnfollowUser(String userId1, String userId2, boolean follow) {
        Optional<UserExample> followingUser = repository.findById(userId1);
        Optional<UserExample> followedUser = repository.findById(userId2);
        if (followingUser.isPresent() && followedUser.isPresent()) {
            if (follow) {
                followingUser.get().follow(followedUser.get());
                followedUser.get().addFollower(followingUser.get());
            } else {
                followingUser.get().unFollow(followedUser.get());
                followedUser.get().removeFollower(followingUser.get());
            }
            return true;
        }
        return false;
    }
}
