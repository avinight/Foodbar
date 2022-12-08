package recipe.foodbar.usecase.recipe.manager;

public interface CreateRecipeOutputBoundary {

    String present(String message);

    String getID(String recipeID);
}
