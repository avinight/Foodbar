package recipe.foodbar.app.rest;

import io.javalin.http.BadRequestResponse;
import io.javalin.http.Handler;
import recipe.foodbar.usecase.review.ReviewInputData;
import recipe.foodbar.usecase.review.ReviewOutputData;
import recipe.foodbar.usecase.review.WriteReviewInteractor;

import java.util.Objects;

public class JavelinReviewController {
    static WriteReviewInteractor writeReviewInteractor;

    public JavelinReviewController(WriteReviewInteractor writeReviewInteractor) {
        JavelinReviewController.writeReviewInteractor = writeReviewInteractor;
    }

    public static Handler createReview = ctx -> {
        ReviewInputData inputData = ctx.bodyAsClass(ReviewInputData.class);
        System.out.println(inputData);
        ReviewOutputData outputData = writeReviewInteractor.writeReview(inputData);
        if (Objects.equals(outputData.getStatus(), "Review saved successfully")) {
            ctx.result("Success");
        } else {
            throw new BadRequestResponse();
        }
    };
}
