package recipe.foodbar.usecase.recipe.manager.sort;

import recipe.foodbar.usecase.recipe.ds.RecipeRequestModel;

public interface IRecipeSorter{
    public void sortByCuisine();
    public void sortByRating(RecipeRequestModel rrm);
}
