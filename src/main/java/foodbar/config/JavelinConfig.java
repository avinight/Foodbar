package foodbar.config;

import com.mongodb.client.MongoDatabase;

import foodbar.controller.recipe.CreateRecipeController;
import foodbar.controller.user.AccountController;
import foodbar.controller.user.AccountPresenter;
import foodbar.presenter.ReviewPresenter;
import foodbar.usecase.commonport.IdGenerator;
import foodbar.usecase.review.WriteReviewInteractor;
import foodbar.usecase.user.UserManager;
import foodbar.usecase.userLogin.UserLogin;
import foodbar.usecase.userLogout.UserLogout;
import foodbar.controller.review.ReviewController;
import foodbar.controller.user.login.UserLoginController;
import foodbar.controller.user.login.UserLoginPresenter;
import foodbar.controller.user.logout.UserLogoutController;
import foodbar.controller.user.logout.UserLogoutPresenter;
import foodbar.id_generator.jug.JugIdGenerator;
import foodbar.repository.mongoDB.MongoDB;
import foodbar.repository.mongoDB.repository.MongoRecipeRepository;
import foodbar.repository.mongoDB.repository.MongoUserRepository;
import foodbar.repository.simpleDB.InMemoryCookieRepository;
import foodbar.usecase.recipe.manager.CreateRecipeInputBoundary;
import foodbar.usecase.recipe.manager.CreateRecipeInteractor;
import foodbar.usecase.recipe.manager.CreateRecipePresenter;
import foodbar.usecase.recipe.port.RecipeRepository;
import foodbar.usecase.review.port.ReviewOutputBoundary;
import foodbar.usecase.user.port.UserCreatorInputBoundary;
import foodbar.usecase.user.port.UserRepository;
import foodbar.usecase.userLogin.port.LoginRepositoryInterface;
import foodbar.usecase.userLogin.port.UserLoginInputBoundary;
import foodbar.usecase.userLogin.port.UserLoginOutputBoundary;
import foodbar.usecase.userLogout.port.UserLogoutInputBoundary;
import foodbar.usecase.userLogout.port.UserLogoutOutputBoundary;

/**
 * JavelinConfig class responsible for passing the required repository, presenter, idgenerator to each REST controller
 */
public class JavelinConfig {
    MongoDatabase db = MongoDB.getMongoDB();
    private final UserRepository userRepository = new MongoUserRepository(db);
    private final RecipeRepository recipeRepository = new MongoRecipeRepository(db);
    LoginRepositoryInterface loggedInRepo = new InMemoryCookieRepository();
    private final IdGenerator idGenerator = new JugIdGenerator();

    //    User Account creation, login, logout
    AccountPresenter accountPresenter = new AccountPresenter();
    UserLoginOutputBoundary userLoginOutputBoundary = new UserLoginPresenter();
    UserLogoutOutputBoundary userLogoutOutputBoundary = new UserLogoutPresenter();
    UserCreatorInputBoundary data = new UserManager(accountPresenter, userRepository, idGenerator);
    UserLoginInputBoundary userLoginInputBoundary = new UserLogin(userLoginOutputBoundary, userRepository, loggedInRepo);
    AccountController accountController = new AccountController(data);
    UserLoginController userLoginController = new UserLoginController(userLoginInputBoundary);
    UserLogoutInputBoundary userLogoutInputBoundary = new UserLogout(userLogoutOutputBoundary, loggedInRepo);
    UserLogoutController userLogoutController = new UserLogoutController(userLogoutInputBoundary);

    //    Recipe Creation
    CreateRecipePresenter createRecipePresenter = new CreateRecipePresenter();
    CreateRecipeInputBoundary recipeData = new CreateRecipeInteractor(recipeRepository, userRepository, idGenerator, createRecipePresenter);
    CreateRecipeController createRecipeController = new CreateRecipeController(recipeData);
    //    Review Creation
    ReviewOutputBoundary outputBoundary = new ReviewPresenter();
    WriteReviewInteractor interactor = new WriteReviewInteractor(recipeRepository, userRepository, outputBoundary);
    ReviewController reviewController = new ReviewController(interactor);

    //    Get Recipe by Cuisine
    public AccountController getAccountController() {
        return accountController;
    }
    public UserLoginController getUserLoginController() {
        return userLoginController;
    }
    public UserLogoutController getUserLogoutController() {
        return userLogoutController;
    }
    public CreateRecipeController getCreateRecipeController() {
        return createRecipeController;
    }
    public WriteReviewInteractor getWriteInteractor() {
        return interactor;
    }
}
