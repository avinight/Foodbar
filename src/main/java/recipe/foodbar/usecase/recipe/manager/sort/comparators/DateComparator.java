package recipe.foodbar.usecase.recipe.manager.sort.comparators;

import recipe.foodbar.entities.Recipe.Recipe;

import java.util.Comparator;

public class DateComparator implements Comparator<Recipe> {
    /**
     * @param r1 the first object to be compared.
     * @param r2 the second object to be compared.
     * @return
     */
    @Override
    public int compare(Recipe r1, Recipe r2) {
        return r1.getDateCreated().compareTo(r2.getDateCreated());
    }
}
