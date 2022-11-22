package recipe.foodbar.controller.user_example;

import recipe.foodbar.controller.dto.UserDTO;
import recipe.foodbar.usecase.user_example.CreateUser;
import recipe.foodbar.usecase.user_example.FindUser;
import recipe.foodbar.usecase.user_example.FollowUnfollowUser;
import recipe.foodbar.usecase.user_example.LoginUser;

import java.util.List;
import java.util.stream.Collectors;

public class UserController {

    private final CreateUser createUser;
    private final FindUser findUser;
    private final LoginUser loginUser;
    private final FollowUnfollowUser followUnfollowUser;

    public UserController(final CreateUser createUser, final FindUser findUser, final LoginUser loginUser, final FollowUnfollowUser followUnfollowUser) {
        this.createUser = createUser;
        this.findUser = findUser;
        this.loginUser = loginUser;
        this.followUnfollowUser = followUnfollowUser;
    }

    public UserDTO createUser(final UserDTO UserDTO) {
        var user = UserDTO.toUser();
        return recipe.foodbar.controller.dto.UserDTO.toUserDTO(createUser.create(user));
    }

    public UserDTO login(final String email, final String password) {
        return UserDTO.toUserDTO(loginUser.login(email, password));
    }

    public UserDTO getUser(final String userId) {
        return UserDTO.toUserDTO(findUser.findById(userId).orElseThrow(() -> new RuntimeException("user not found")));
    }

    public boolean followUser(String userId1, String userId2) {
        //return FollowUser(userId1, userId2, ).follow();
        return followUnfollowUser.followUnfollowUser(userId1, userId2, true);
    }

    public List<UserDTO> allUsers() {
        return findUser.findAllUsers()
                .stream()
                .map(UserDTO::toUserDTO)
                .collect(Collectors.toList());
    }
}