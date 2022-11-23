package recipe.foodbar.usecase.sort;

import recipe.foodbar.entities.Recipe;

import java.util.List;

public class RecipeSorter implements Sorter{
    private final List<Recipe> array;
    /* Depends on DAI */
    public RecipeSorter(List<Recipe> array) {
        this.array = array;
    }

    public <T> void sortBy(AbstractComparator comparator) {
        this.array.sort(comparator);
    }
}
