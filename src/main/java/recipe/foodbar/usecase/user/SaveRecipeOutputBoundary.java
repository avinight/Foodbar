/*
Output boundary interface allows for dependency inversion so that it can be used by the presenter in the
outer layer
 */
package recipe.foodbar.usecase.user_example;

public interface SaveRecipeOutputBoundary {

    /**
     * Method which returns the message acknowledging that the recipe has been saved/unsaved
     * @param message the String message to be displayed
     * @return The message to be displayed upon successful saving/unsaving of the recipe
     */
    String present(String message);
}
