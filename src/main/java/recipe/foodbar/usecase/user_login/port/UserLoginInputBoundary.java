package recipe.foodbar.usecase.user_login.port;


import recipe.foodbar.usecase.user_login.UserLoginInput;

public interface UserLoginInputBoundary {

    String login(UserLoginInput input);

}
