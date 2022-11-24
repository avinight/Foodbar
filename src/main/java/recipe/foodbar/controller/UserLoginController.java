package recipe.foodbar.controller;
import recipe.foodbar.usecase.user_login.UserLoginInput;
import recipe.foodbar.usecase.user_login.port.UserLoginInputBoundary;

public class UserLoginController {

    public final UserLoginInputBoundary data;

    public UserLoginController(UserLoginInputBoundary data){
        this.data = data;
    }

    public UserLoginInput create(String username, String password){
        UserLoginInput UserLogin = new UserLoginInput(username, password);

        return UserLogin;
    }





}
