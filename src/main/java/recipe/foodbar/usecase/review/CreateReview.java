package recipe.foodbar.usecase.review;

import recipe.foodbar.entities.Recipe;
import recipe.foodbar.entities.Review;
import recipe.foodbar.usecase.recipe.port.RecipeRepository;
import recipe.foodbar.usecase.review.exception.CharLimitException;
import recipe.foodbar.usecase.review.validator.ReviewValidator;
import recipe.foodbar.usecase.user_example.port.IdGenerator;

public class CreateReview {
    private final RecipeRepository repository;
    private final IdGenerator idGenerator;

    private final String recipeId;

    public CreateReview(RecipeRepository repository, IdGenerator idGenerator, String recipeId) {
        this.repository = repository;
        this.idGenerator = idGenerator;
        this.recipeId = recipeId;
    }

    public Recipe createReview(Review review) {
        ReviewValidator.validateCreateReview(review);
        if (review.getText().length() > review.getMaxLength()) {
            throw new CharLimitException("Exceeded the maximum character limit");
        }
        Review reviewToSave = Review.builder()
                .id(idGenerator.generate())
                .title(review.getTitle())
                .text(review.getText())
                .author(review.getAuthor())
                .build();
        repository.findById(recipeId).get().addReview(reviewToSave);
        return repository.findById(recipeId).get();
    }
}
