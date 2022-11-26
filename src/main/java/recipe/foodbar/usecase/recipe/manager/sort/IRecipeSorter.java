package recipe.foodbar.usecase.recipe.manager.sort;


import recipe.foodbar.interfaces.Sorter;

public interface IRecipeSorter extends Sorter {
    public void sortByCuisine();
    public void sortByRating();
    public void sortByDate();
}
