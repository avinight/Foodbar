package recipe.foodbar.usecase.userLogout.port;


import recipe.foodbar.usecase.userLogout.UserLogoutInput;

public interface UserLogoutInputBoundary {

    /**
     * Abstract logout method to be implemented
     *
     * @param input the UserLogoutInput object to be passed in
     * @return to be implemented
     */
    public String logout(UserLogoutInput input);
}
