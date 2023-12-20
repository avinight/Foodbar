package foodbar.usecase.userLogout.port;


import foodbar.usecase.userLogout.UserLogoutInput;

/**
 * Interface for the interactor to implement so controller can avoid breach of dependency rules
 */
public interface UserLogoutInputBoundary {

    /**
     * Abstract logout method to be implemented
     *
     * @param input the UserLogoutInput object to be passed in
     * @return to be implemented
     */
    String logout(UserLogoutInput input);
}
