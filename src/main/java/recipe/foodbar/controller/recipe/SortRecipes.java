package recipe.foodbar.controller.recipe;

import recipe.foodbar.usecase.recipe.ds.RecipeRequestModel;
import recipe.foodbar.usecase.recipe.manager.sort.IRecipeSorter;

/**
 * A controller to sort recipes.
 */
public class SortRecipes {
    private final RecipeRequestModel rrm;
    private IRecipeSorter s;

    public SortRecipes(RecipeRequestModel rrm, IRecipeSorter s) {
        this.s = s;
        this.rrm = rrm;

    }

    public void sort() {
        /* if request is cuisine */
        s.sortByCuisine();
        /* if request is rating */
        s.sortByRating(this.rrm);
    }

}
