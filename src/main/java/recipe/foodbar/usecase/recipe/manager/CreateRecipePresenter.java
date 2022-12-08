package recipe.foodbar.usecase.recipe.manager;

public class CreateRecipePresenter implements CreateRecipeOutputBoundary {


    @Override
    public String present(String message) {
        return message;
    }

    @Override
    public String getID(String recipeID) {
        return recipeID;
    }
}
