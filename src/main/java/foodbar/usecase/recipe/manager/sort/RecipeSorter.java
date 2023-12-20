package foodbar.usecase.recipe.manager.sort;

import foodbar.presenter.RecipePresenter;
import foodbar.usecase.recipe.port.RecipeRepository;

public class RecipeSorter extends Sorter implements IRecipeSorter {

    private final RecipeRepository recipeRepo;
    private final RecipePresenter rp;

    /* Depends on DAI */
    public RecipeSorter(RecipeRepository recipeRepo, RecipePresenter rp) {
        this.recipeRepo = recipeRepo;
        this.rp = rp;
    }

    @Override
    public void sortByCuisine() {
        this.recipeRepo.getAllRecipes().sort(new CuisineComparator());
    }

    @Override
    public void sortByRating() {
        this.recipeRepo.getAllRecipes().sort(new RatingComparator());
    }
}
