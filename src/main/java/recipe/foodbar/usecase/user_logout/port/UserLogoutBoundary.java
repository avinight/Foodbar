package recipe.foodbar.usecase.user_logout.port;

import recipe.foodbar.usecase.user_logout.UserLogoutInput;

public interface UserLogoutBoundary {

    /**
     * Abstract logout method to be implemented
     *
     * @param input the UserLogoutInput object to be passed in
     * @return to be implemented
     */
    public String logout(UserLogoutInput input);
}
