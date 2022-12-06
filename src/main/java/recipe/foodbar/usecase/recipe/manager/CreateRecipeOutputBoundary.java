package recipe.foodbar.usecase.recipe.manager;

public interface CreateRecipeOutputBoundary {

    String getConfirmationMessage();

    String getID(String recipeID);
}
