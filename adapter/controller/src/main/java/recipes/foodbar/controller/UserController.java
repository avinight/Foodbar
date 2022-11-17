package recipe.foodbar.controller;

import recipe.foodbar.controller.dto.UserDTO;
import recipe.foodbar.usecase.user.CreateUser;
import recipe.foodbar.usecase.user.FindUser;
import recipe.foodbar.usecase.user.LoginUser;

import java.util.List;
import java.util.stream.Collectors;

public class UserController {

    private final CreateUser createUser;
    private final FindUser findUser;
    private final LoginUser loginUser;

    public UserController(final CreateUser createUser, final FindUser findUser, final LoginUser loginUser) {
        this.createUser = createUser;
        this.findUser = findUser;
        this.loginUser = loginUser;
    }

    public UserDTO createUser(final UserDTO UserDTO) {
        var user = UserDTO.toUser();
        return UserDTO.toUserDTO(createUser.create(user));
    }

    public UserDTO login(final String email, final String password) {
        return UserDTO.toUserDTO(loginUser.login(email, password));
    }

    public UserDTO getUser(final String userId) {
        return UserDTO.toUserDTO(findUser.findById(userId).orElseThrow(() -> new RuntimeException("user not found")));
    }

    public List<UserDTO> allUsers() {
        return findUser.findAllUsers()
                .stream()
                .map(UserDTO::toUserDTO)
                .collect(Collectors.toList());
    }
}