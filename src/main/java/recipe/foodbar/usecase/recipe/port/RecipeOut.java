package recipe.foodbar.usecase.recipe.port;

import recipe.foodbar.usecase.recipe.RecipeResponseModel;

public interface RecipeOut {
    public default void displayEdited(RecipeResponseModel.ResponseDataType type) {}
}
