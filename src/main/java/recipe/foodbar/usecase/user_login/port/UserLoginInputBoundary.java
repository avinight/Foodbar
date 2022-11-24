package recipe.foodbar.usecase.user_login.port;


import recipe.foodbar.repository.simpleDB.InMemoryUserRepository;
import recipe.foodbar.usecase.user_login.UserLoginInput;

public interface UserLoginInputBoundary {

    String login(UserLoginInput input);

}
