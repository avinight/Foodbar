package recipe.foodbar.usecase.recipe.manager;

public class CreateRecipePresenter implements CreateRecipeOutputBoundary {

    /**
     * Presenter for recipe creation
     *
     * @param message The response to be presented
     * @return The response message presented
     */
    @Override
    public String present(String message) {
        return message;
    }

    @Override
    public String getID(String recipeID) {
        return recipeID;
    }
}
