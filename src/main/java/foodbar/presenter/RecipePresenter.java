package foodbar.presenter;

import foodbar.usecase.recipe.ds.RecipeResponseModel;
import foodbar.usecase.recipe.port.RecipeOut;

public class RecipePresenter implements RecipeOut {

    @Override
    public void displayEdited(RecipeResponseModel.ResponseDataType type) {
        System.out.println(RecipeResponseModel.getRecipeResponseText(type));
    }
}
