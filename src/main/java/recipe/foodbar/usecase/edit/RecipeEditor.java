package recipe.foodbar.usecase.edit;

import recipe.foodbar.entities.Recipe;

// import recipe class
public class RecipeEditor implements Editor {
    private final Recipe recipe;

    /**
     * Constructor for the RecipeEditor class, initializes a RecipeEditor.
     *
     * @param recipe A recipe object.
     */
    public RecipeEditor(Recipe recipe) {
        this.recipe = recipe;
    }

    /**
     * Edits the portionSize of a Recipe object.
     *
     * @param portionSize The portion size of a recipe.
     */
    public void editPortionSize(int portionSize) {
        this.recipe.modifyIngredients(portionSize);
    }

}
