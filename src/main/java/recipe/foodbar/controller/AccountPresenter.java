package recipe.foodbar.controller;

import recipe.foodbar.usecase.UserCreatorOutputBoundary;

public class AccountPresenter implements UserCreatorOutputBoundary {

    @Override
    public String present(String message) {
        return message;
    }

}
