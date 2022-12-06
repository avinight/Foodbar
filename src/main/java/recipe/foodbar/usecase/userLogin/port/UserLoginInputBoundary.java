package recipe.foodbar.usecase.userLogin.port;


import recipe.foodbar.usecase.userLogin.UserLoginInput;

public interface UserLoginInputBoundary {

    String login(UserLoginInput input);

}
