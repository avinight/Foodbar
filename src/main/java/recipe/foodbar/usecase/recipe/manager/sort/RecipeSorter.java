package recipe.foodbar.usecase.recipe.manager.sort;

import recipe.foodbar.entities.Recipe.Recipe;
import recipe.foodbar.presenter.RecipePresenter;
import recipe.foodbar.usecase.recipe.ds.RecipeRequestModel;
import recipe.foodbar.usecase.recipe.ds.RecipeResponseModel;
import recipe.foodbar.usecase.recipe.port.RecipeRepository;

import java.util.ArrayList;
import java.util.List;

public class RecipeSorter implements Sorter{

    private final RecipeRepository recipeRepo;
    private final RecipePresenter rp;
    /* Depends on DAI */
    public RecipeSorter(RecipeRepository recipeRepo, RecipePresenter rp) {
        this.recipeRepo = recipeRepo;
        this.rp = rp;
    }

    public RecipeResponseModel sortByCuisine() {
        this.recipeRepo.getAllRecipes().sort(new CuisineComparator());
    }

    public <T> void sortByRating(RecipeRequestModel rrm) {
        this.recipeRepo.getAllRecipes().sort(new RatingComparator());
    }
}
