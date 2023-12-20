package foodbar.usecase.userLogin.port;
import foodbar.usecase.userLogin.UserLoginInput;

/**
 * UserLoginInputBoundary to be implemented by the interactor
 */

public interface UserLoginInputBoundary {

    String login(UserLoginInput input);

}
