package recipe.foodbar.usecase.review;

import recipe.foodbar.entities.Review;
import recipe.foodbar.usecase.recipe.port.RecipeRepository;
import recipe.foodbar.usecase.review.exception.CharLimitException;
import recipe.foodbar.usecase.review.validator.ReviewValidator;
import recipe.foodbar.usecase.user_example.port.IdGenerator;

public class CreateReview {
    private final IdGenerator idGenerator;

    private final String recipeId;

    public CreateReview(RecipeRepository repository, IdGenerator idGenerator, String recipeId) {
        this.idGenerator = idGenerator;
        this.recipeId = recipeId;
    }

    public Review createReview(Review review) throws CharLimitException{
        ReviewValidator.validateCreateReview(review);
        if (review.getText().length() > Review.MAX_LENGTH) {
            throw new CharLimitException("Exceeded the maximum character limit");
        }
        return Review.builder()
                .id(idGenerator.generate())
                .recipeId(recipeId)
                .title(review.getTitle())
                .text(review.getText())
                .author(review.getAuthor())
                .build();
    }
}
