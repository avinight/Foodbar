package recipe.foodbar.usecase.sort;

import recipe.foodbar.entities.Recipe;

import java.util.List;

public class RecipeSorter implements Sorter{
    private final AbstractComparator comparator;

    public RecipeSorter(AbstractComparator comparator) {
        this.comparator = comparator;
    }

    public <T> void sortBy(List<Recipe> array) {
        array.sort(this.comparator);
    }
}
