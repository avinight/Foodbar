package recipe.foodbar.controller.recipe;

import recipe.foodbar.usecase.recipe.manager.sort.IRecipeSorter;
import recipe.foodbar.usecase.recipe.manager.sort.comparators.CuisineComparator;
import recipe.foodbar.usecase.recipe.manager.sort.comparators.DateComparator;
import recipe.foodbar.usecase.recipe.manager.sort.comparators.RatingComparator;

/**
 * A controller to sort recipes.
 */
public class SortRecipes {
    private final IRecipeSorter s;

    /**
     * Constructor for SortRecipes.
     *
     * @param s IRecipeSorter
     */
    public SortRecipes(IRecipeSorter s) {
        this.s = s;
        /* TODO: Click button Input Data from user. */
    }

    /**
     * Sorts the
     *
     * @param order string
     */
    public void sort(String order) {
        switch (order) {
            case "by_rating":
                s.sortBy(new RatingComparator());
            case "by_cuisine":
                s.sortBy(new CuisineComparator());
            case "by_date_created":
                s.sortBy(new DateComparator());
        }
    }

}
