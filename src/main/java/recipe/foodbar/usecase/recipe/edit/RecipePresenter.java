package recipe.foodbar.usecase.recipe.edit;

import recipe.foodbar.usecase.recipe.RecipeResponseModel;
import recipe.foodbar.usecase.recipe.port.RecipeOut;

public class RecipePresenter implements RecipeOut {

    @Override
    public void displayEdited(RecipeResponseModel.ResponseDataType type) {
        System.out.println(RecipeResponseModel.getRecipeResponseText(type));
    }
}
