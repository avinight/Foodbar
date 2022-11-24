package recipe.foodbar.usecase.user_logout;

import recipe.foodbar.usecase.user_login.port.LoginRepositoryInterface;
import recipe.foodbar.usecase.user_login.port.UserLoginOutputBoundary;
import recipe.foodbar.usecase.user_logout.port.UserLogoutBoundary;

public class UserLogout implements UserLogoutBoundary {

    private final UserLoginOutputBoundary output;
    private final LoginRepositoryInterface loginRepo;


    /**
     * Constructor for UserLogout interactor
     *
     * @param output the output boundary interface
     * @param loginRepo the logged-in users repository
     */
    public UserLogout(UserLoginOutputBoundary output,
                      LoginRepositoryInterface loginRepo){
        this.output = output;
        this.loginRepo = loginRepo;


    }

    /**
     * Overriden method of logging out from the logout boundary interface
     *
     * @param input the UserLogoutInput object to be passed into the interactor method
     * @return message depending on the success or failure of the removal
     */
    public String logout(UserLogoutInput input){

        String cookie = input.getCookie();
        if (loginRepo.findByCookie(cookie).isPresent()){

            loginRepo.remove(cookie);
            return output.message("User Successfully Logged Out");
        }
        return output.message("User Logout failed");

    }
}
