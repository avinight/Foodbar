package recipe.foodbar.usecase.review;

import recipe.foodbar.entities.Review;
import recipe.foodbar.usecase.recipe.port.RecipeRepository;
import recipe.foodbar.usecase.review.exception.CharLimitException;
import recipe.foodbar.usecase.review.validator.ReviewValidator;

public class CreateReview {
    private final RecipeRepository repository;

    public CreateReview(RecipeRepository repository) {
        this.repository = repository;
    }

    public Review createReview(Review review) {
        ReviewValidator.validateCreateReview(review);
        if (review.getText().length() > Review.MAX_LENGTH) {
            throw new CharLimitException("Exceeded the maximum character limit");
        }
        Review reviewToSave = Review.builder()
                .title(review.getTitle())
                .text(review.getText())
                .author(review.getAuthor())
                .build();
        // need jimmy to do his part so I can add review to the recipe
        return reviewToSave;
    }
}
