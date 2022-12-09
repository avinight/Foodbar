package recipe.foodbar.usecase.recipe.manager;

public interface CreateRecipeInputBoundary {
    /**
     * Input boundary in the use case for recipe creation
     *
     * @param input input data from the controller
     *
     * @return String to be presented to the presenter
     */
    String create(RecipeInputData input);
}
