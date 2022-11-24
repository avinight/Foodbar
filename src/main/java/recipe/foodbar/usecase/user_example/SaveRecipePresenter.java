package recipe.foodbar.usecase.user_example;

import recipe.foodbar.usecase.user_example.SaveRecipeOutputBoundary;

public class SaveRecipePresenter implements SaveRecipeOutputBoundary {
    /**
     * Method which returns the message acknowledging that the recipe has been saved/unsaved
     *
     * @param message the String message to be displayed
     * @return The message to be displayed upon successful saving/unsaving of the recipe
     */
    @Override
    public String present(String message) {
        return message;
    }
}
