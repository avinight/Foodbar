package foodbar.usecase.review;

import foodbar.entities.Recipe;
import foodbar.entities.Review;
import foodbar.usecase.recipe.port.RecipeRepository;
import foodbar.usecase.review.port.ReviewInputBoundary;
import foodbar.usecase.review.port.ReviewOutputBoundary;
import foodbar.usecase.review.validator.ReviewValidator;
import foodbar.usecase.user.port.UserRepository;

public class WriteReviewInteractor implements ReviewInputBoundary {
    private final RecipeRepository recipeRepository;
    private final UserRepository userRepository;
    private ReviewOutputBoundary outputBoundary;

    public WriteReviewInteractor(RecipeRepository recipeRepository, UserRepository userRepository, ReviewOutputBoundary outputBoundary) {
        this.recipeRepository = recipeRepository;
        this.userRepository = userRepository;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public ReviewOutputData writeReview(ReviewInputData inputData) {
        ReviewValidator.validateCreateReview(inputData);
        if (userRepository.findById(inputData.getUserId()).isPresent()) {
            Review reviewToSave = Review.builder().recipeId(inputData.getRecipeId()).title(inputData.getTitle()).text(inputData.getText()).author(userRepository.findById(inputData.getUserId()).get()).build();
            if (recipeRepository.findById(reviewToSave.getRecipeId()).isPresent()) {
                Recipe recipe = recipeRepository.findById(reviewToSave.getRecipeId()).get();
                recipe.addReview(reviewToSave);
                recipeRepository.update(recipe);
                System.out.println("Review saved successfully");
                return outputBoundary.present(reviewToSave, "Review saved successfully");
            }
        }
        return outputBoundary.present(new Review(), "review not saved");
    }
}
