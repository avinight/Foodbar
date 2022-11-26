package recipe.foodbar.usecase.recipe.manager.sort;

import recipe.foodbar.presenter.RecipePresenter;
import recipe.foodbar.usecase.recipe.manager.sort.comparators.CuisineComparator;
import recipe.foodbar.usecase.recipe.manager.sort.comparators.DateComparator;
import recipe.foodbar.usecase.recipe.manager.sort.comparators.RatingComparator;
import recipe.foodbar.usecase.recipe.port.RecipeRepository;

public class RecipeSorter implements IRecipeSorter {

    private final RecipeRepository recipeRepo;
    private final RecipePresenter rp;

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

    @Override
    public void sortByDate() { this.recipeRepo.getAllRecipes().sort(new DateComparator());}
}
