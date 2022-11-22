package recipe.foodbar.usecase.sort;

import java.util.ArrayList;
import java.util.List;

public class RecipeSorter implements Sorter{
    private Sorting<Object> comparator = null;

    public RecipeSorter(List<Object> array, Sorting<Object> comparator) {
        this.comparator = comparator;
    }

    public <T> void sortBy(List<Object> array) {
        array.sort(this.comparator);
    }
}
