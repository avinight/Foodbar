package foodbar.app;

import io.javalin.Javalin;
import foodbar.config.JavelinConfig;

public class JavelinApplication {

    public static void main(String[] args) {
        // Get the config for repository, presenter, controller and other adapters to use for each use case
        JavelinConfig javelinConfig = new JavelinConfig();

        // Creates the controller Responsible for each REST path
        JavelinUserController userController = new JavelinUserController(javelinConfig.getAccountController(),
                javelinConfig.getUserLoginController(),
                javelinConfig.getUserLogoutController());
        JavelinRecipeController recipeController = new JavelinRecipeController(javelinConfig.getCreateRecipeController());
        JavelinReviewController reviewController = new JavelinReviewController(javelinConfig.getWriteInteractor());

        // For debug purposes, so we know the webserver is running or not
        var app = Javalin.create().get("/", ctx -> ctx.result("Hello World!")).start(4040);

        //User
        app.post("/api/register", userController.createUser);
        app.post("/api/login", userController.loginUser);
        app.get("/api/logout", userController.logoutUser);

        //Recipe
        app.post("/api/recipe", recipeController.createRecipe);

        //Review
        app.post("/api/review", reviewController.createReview);
    }
}
