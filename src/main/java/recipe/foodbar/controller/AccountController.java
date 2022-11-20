package recipe.foodbar.controller;

import recipe.foodbar.usecase.user.port.UserCreatorInputBoundary;
import recipe.foodbar.usecase.user.UserInputData;

/*
 * Controller is to pass the username, password and passwordShadow required by the UserManager,
 * and then to run the usercase through the UserCreatorInputBoundary Interface.
 */



public class AccountController {

    public final UserCreatorInputBoundary data;


    /**
     * Constructor for AccountController taking in the UserCreatorInputBoundary object
     * @param data representing the given UserCreatorInputBoundary object
     */
    public AccountController(UserCreatorInputBoundary data) {
        this.data = data;

    }


    /**
     * The UserInputData create method to combine the necessary data into a userInputData object
     * to be passed to the usecase interactor
     * @param username The String representation of the username
     * @param password The String representation of the password
     * @param passwordShadow The String representation of the second entry of the password
     * @param firstName The String representation of the first name
     * @param lastName The String representation of the last name
     * @param email The String representation of the email
     * @return the completed UserInputData object
     */
    public UserInputData create(String username, String password, String passwordShadow,
                                String firstName, String lastName, String email){
        UserInputData userInput = new UserInputData(username, password,
                passwordShadow, firstName, lastName, email);

        return userInput;
    }



}
