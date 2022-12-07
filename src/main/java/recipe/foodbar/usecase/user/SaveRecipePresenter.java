package recipe.foodbar.usecase.user;

public class SaveRecipePresenter implements SaveRecipeOutputBoundary {
    /**
     * Method which returns the message acknowledging that the recipe has been saved/unsaved
     *
     * @param message the String message to be displayed
     * @return The message to be displayed upon successful saving/unsaving of the recipe
     */

    // TODO: should i have a constructor object? What attributes if any?
    @Override
    public String present(String message) {
        return message;
    }
}
