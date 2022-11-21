package recipe.foodbar.controller.review;

import recipe.foodbar.usecase.review.CreateReview;

public class ReviewController {
    private final CreateReview createReview;

    public ReviewController(final CreateReview createRecipe) {
        this.createReview = createRecipe;
    }
}
