package recipe.foodbar.controller;

import recipe.foodbar.usecase.UserCreatorInputBoundary;
import recipe.foodbar.usecase.UserInputData;

/**
 * Controller is to pass the username, password and passwordShadow required by the UserManager,
 * and then to run the usercase through the UserCreatorInputBoundary Interface.
 */



public class AccountController {

    public final UserCreatorInputBoundary data;

    public AccountController(UserCreatorInputBoundary data) {
        this.data = data;

    }

    public UserInputData create(String username, String password, String passwordShadow,
                                String firstName, String lastName, String email){
        UserInputData userInput = new UserInputData(username, password,
                passwordShadow, firstName, lastName, email);

        return userInput;
    }



}
