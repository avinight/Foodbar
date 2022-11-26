package recipe.foodbar.controller.recipe;

import recipe.foodbar.usecase.recipe.manager.sort.IRecipeSorter;

/**
 * A controller to sort recipes.
 */
public class SortRecipes {
    private final IRecipeSorter s;

    /**
     * Constructor for SortRecipes.
     *
     * @param s  IRecipeSorter
     */
    public SortRecipes(IRecipeSorter s) {
        this.s = s;
        /* TODO: Click button Input Data from user. */
    }

    /**
     * Sorts the
     * @param order string
     */
    public void sort(String order) {
        switch (order) {
            case "by_rating":
                s.sortByRating();
            case "by_cuisine":
                s.sortByCuisine();
            case "by_date_created":
                s.sortByDate();
        }
    }

}
