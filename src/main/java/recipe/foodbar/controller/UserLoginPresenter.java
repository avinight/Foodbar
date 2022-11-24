package recipe.foodbar.controller;


import recipe.foodbar.usecase.user_login.port.UserLoginOutputBoundary;

public class UserLoginPresenter implements UserLoginOutputBoundary {

    /**
     * Method to return the success or failure message of user login process
     *
     * @param message String representation of the message
     * @return return the given message
     */
    @Override
    public String message(String message){
        return message;
    }

}
