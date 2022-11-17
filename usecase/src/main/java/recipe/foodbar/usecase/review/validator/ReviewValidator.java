package recipe.foodbar.usecase.review.validator;

import recipes.foodbar.entities.Review;
import recipes.foodbar.usecase.user.exception.UserValidationException;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class ReviewValidator {
    public static void validateCreateReview(final Review review) {
        if (review == null) throw new UserValidationException("Review should not be null");
        if (isBlank(review.getTitle())) throw new UserValidationException("Title should not be null");
        if (isBlank(review.getText())) throw new UserValidationException("Text should not be null");
        if (review.getAuthor() == null) throw new UserValidationException("Author should not be null");
    }
}
