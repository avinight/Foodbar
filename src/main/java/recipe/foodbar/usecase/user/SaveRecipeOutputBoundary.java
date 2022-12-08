/*
Output boundary interface allows for dependency inversion so that it can be used by the presenter in the
outer layer
 */
package recipe.foodbar.usecase.user;

public interface SaveRecipeOutputBoundary {

    /**
     * Method which returns the message acknowledging that the recipe has been saved/unsaved
     *
     * @param message the String message to be displayed
     * @return The return type of the presenter interface
     */
    String present(String message);
}
