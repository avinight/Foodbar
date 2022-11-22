package recipe.foodbar.usecase.sort;

import recipe.foodbar.entities.Cuisine;

public class CuisineComparator implements Sorting<Cuisine>{
    /**
     * Compares its two arguments for order.  Returns a negative integer,
     * zero, or a positive integer as the first argument is less than, equal
     * to, or greater than the second.
     * @param c1 the first object to be compared.
     * @param c2 the second object to be compared.
     * @return a negative integer, zero, or a positive integer as the
     * first argument is less than, equal to, or greater than the
     * second.
     * @throws NullPointerException if an argument is null and this
     *                              comparator does not permit null arguments
     * @throws ClassCastException   if the arguments' types prevent them from
     *                              being compared by this comparator.
     */
    @Override
    public int compare(Cuisine c1, Cuisine c2) {
        return String.CASE_INSENSITIVE_ORDER.compare(c1.getName(), c2.getName());
    }
}
