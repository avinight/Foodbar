package recipe.foodbar.usecase.recipe.manager.sort;

import recipe.foodbar.entities.Recipe.Recipe;

/**
 * This comparator class is responsible for comparing two recipes and returning an ordering based on rating
 * (used to reorder by rating)
 */
public class RatingComparator extends AbstractComparator {

    /**
     * Compares its two arguments for order.  Returns a negative integer,
     * zero, or a positive integer as the first argument is less than, equal
     * to, or greater than the second.
     * @param r1 the first object to be compared.
     * @param r2 the second object to be compared.
     * @return a negative integer, zero, or a positive integer as the
     * first argument is less than, equal to, or greater than the
     * second.
     * @throws NullPointerException if an argument is null and this
     *                              comparator does not permit null arguments
     * @throws ClassCastException   if the arguments' types prevent them from
     *                              being compared by this comparator.
     */
    @Override
    public int compare(Recipe r1, Recipe r2) {
        /*
        Comparable recipe?
         */
        return r1.getRating() - r2.getRating();
    }
}
