package recipe.foodbar.usecase.recipe.manager.sort;

import recipe.foodbar.presenter.RecipePresenter;
import recipe.foodbar.usecase.recipe.ds.RecipeRequestModel;
import recipe.foodbar.usecase.recipe.port.RecipeRepository;

public class RecipeRecipeSorter extends Sorter implements IRecipeSorter {

    private final RecipeRepository recipeRepo;
    private final RecipePresenter rp;
    /* Depends on DAI */
    public RecipeRecipeSorter(RecipeRepository recipeRepo, RecipePresenter rp) {
        this.recipeRepo = recipeRepo;
        this.rp = rp;
    }


    public void sortByCuisine() {
        this.recipeRepo.getAllRecipes().sort(new CuisineComparator());
    }

    public void sortByRating(RecipeRequestModel rrm) {
        this.recipeRepo.getAllRecipes().sort(new RatingComparator());
    }
}
