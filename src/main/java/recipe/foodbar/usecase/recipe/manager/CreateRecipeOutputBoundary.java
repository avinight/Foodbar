package recipe.foodbar.usecase.recipe.manager;

public interface CreateRecipeOutputBoundary {

    /**
     * Method which returns the message acknowledging that the recipe has been created or not
     *
     * @param message the String message to be displayed
     * @return The message to be displayed upon successful creation of the recipe
     */
    String present(String message);

    /**
     * Returns the ID of the recipe
     * @param recipeID ID of the recipe
     * @return Recipe ID
     */
    String getID(String recipeID);
}
