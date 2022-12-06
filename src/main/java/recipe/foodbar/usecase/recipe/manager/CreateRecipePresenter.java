package recipe.foodbar.usecase.recipe.manager;

public class CreateRecipePresenter implements CreateRecipeOutputBoundary {


    @Override
    public String getConfirmationMessage() {
        return "Recipe successfully saved";
    }

    @Override
    public String getID(String recipeID) {
        return recipeID;
    }
}
