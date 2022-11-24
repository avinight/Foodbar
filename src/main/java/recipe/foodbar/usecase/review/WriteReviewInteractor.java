package recipe.foodbar.usecase.review;

import recipe.foodbar.usecase.recipe.port.RecipeRepository;
import recipe.foodbar.usecase.user_example.port.IdGenerator;

public class WriteReviewInteractor {
    private final RecipeRepository repository;
    private final IdGenerator idGenerator;

    private final String recipeId;

    public WriteReviewInteractor(RecipeRepository repository, IdGenerator idGenerator, String recipeId) {
        this.repository = repository;
        this.idGenerator = idGenerator;
        this.recipeId = recipeId;
    }

    // public ()
}
