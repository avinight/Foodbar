package recipe.foodbar.usecase.recipe.manager;

import java.util.Optional;

public interface CreateRecipeOutputBoundary {

    String getConfirmationMessage();

    String getID(String recipeID);
}
