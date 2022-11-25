package recipe.foodbar.usecase.review;

import recipe.foodbar.controller.dto.ReviewDTO;
import recipe.foodbar.usecase.recipe.port.RecipeRepository;
import recipe.foodbar.usecase.review.port.ReviewInputBoundary;
import recipe.foodbar.usecase.user.port.IdGenerator;

public class WriteReviewInteractor implements ReviewInputBoundary {
    private final RecipeRepository repository;
    private final IdGenerator idGenerator;

    private final String recipeId;

    public WriteReviewInteractor(RecipeRepository repository, IdGenerator idGenerator, String recipeId) {
        this.repository = repository;
        this.idGenerator = idGenerator;
        this.recipeId = recipeId;
    }

    @Override
    public ReviewDTO writeReview(ReviewDTO reviewDTO) {
        return null;
    }
}
