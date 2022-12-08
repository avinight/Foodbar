package recipe.foodbar.usecase.review.validator;

import recipe.foodbar.usecase.review.ReviewInputData;
import recipe.foodbar.usecase.review.exception.ReviewValidationException;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class ReviewValidator {
    public static void validateCreateReview(final ReviewInputData review) {
        if (review == null) throw new ReviewValidationException("Review should not be null");
        if (isBlank(review.getTitle())) throw new ReviewValidationException("Title should not be null");
        if (isBlank(review.getText())) throw new ReviewValidationException("Text should not be null");
        if (review.getUserId() == null) throw new ReviewValidationException("Author should not be null");
        if (review.getText().length() >= 300)
            throw new ReviewValidationException("Review exceeds the character limit!");
    }
}
