package foodbar.controller.user.logout;


import foodbar.usecase.userLogout.port.UserLogoutOutputBoundary;

public class UserLogoutPresenter implements UserLogoutOutputBoundary {

    /**
     * Method to return the success or failure message of user logout process
     *
     * @param message String representation of the message
     * @return return the given message
     */
    @Override
    public String message(String message) {
        return message;
    }

}
