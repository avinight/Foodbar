package recipe.foodbar.controller;


import recipe.foodbar.usecase.user_login.port.UserLoginOutputBoundary;

public class UserLoginPresenter implements UserLoginOutputBoundary {

    @Override
    public String message(String message){
        return message;
    }

}
