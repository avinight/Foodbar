package recipe.foodbar.presenter;

import recipe.foodbar.usecase.recipe.ds.RecipeResponseModel;
import recipe.foodbar.usecase.recipe.port.RecipeOut;

public class RecipePresenter implements RecipeOut {

    @Override
    public void displayEdited(RecipeResponseModel.ResponseDataType type) {
        System.out.println(RecipeResponseModel.getRecipeResponseText(type));
    }
}
