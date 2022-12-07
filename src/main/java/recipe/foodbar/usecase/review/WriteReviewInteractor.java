package recipe.foodbar.usecase.review;

import recipe.foodbar.controller.dto.ReviewDTO;
import recipe.foodbar.entities.Review;
import recipe.foodbar.repository.mongoDB.model.RecipeModel;
import recipe.foodbar.usecase.review.exception.CharLimitException;
import recipe.foodbar.usecase.review.port.ReviewInputBoundary;
import recipe.foodbar.usecase.user.port.IdGenerator;

public class WriteReviewInteractor implements ReviewInputBoundary {
    private final RecipeModel recipeModel;
    private final String recipeId;

    public WriteReviewInteractor(RecipeModel recipeModel, IdGenerator idGenerator, String recipeId) {
        this.recipeModel = recipeModel;
        this.recipeId = recipeId;
    }

    @Override
    public Review writeReview(ReviewDTO reviewDTO) {
        if (reviewDTO.getText().length() > Review.MAX_LENGTH) {
            throw new CharLimitException("The review exceeds the character limit!");
        }
        Review reviewToSave = Review.builder()
                .recipeId(reviewDTO.getRecipeId())
                .title(reviewDTO.getTitle())
                .text(reviewDTO.getText())
                .author(reviewDTO.getAuthor())
                .build();
        recipeModel.getReviews().add(reviewToSave);
        return reviewToSave;
    }
}
