package recipe.foodbar.config;

import com.mongodb.client.MongoDatabase;
import recipe.foodbar.controller.recipe.CreateRecipeController;
import recipe.foodbar.controller.user.AccountController;
import recipe.foodbar.controller.user.AccountPresenter;
import recipe.foodbar.controller.user.login.UserLoginController;
import recipe.foodbar.controller.user.login.UserLoginPresenter;
import recipe.foodbar.controller.user.logout.UserLogoutController;
import recipe.foodbar.controller.user.logout.UserLogoutPresenter;
import recipe.foodbar.id_generator.jug.JugIdGenerator;
import recipe.foodbar.repository.mongoDB.MongoDB;
import recipe.foodbar.repository.mongoDB.repository.MongoRecipeRepository;
import recipe.foodbar.repository.mongoDB.repository.MongoUserRepository;
import recipe.foodbar.repository.simpleDB.InMemoryCookieRepository;
import recipe.foodbar.usecase.commonport.IdGenerator;
import recipe.foodbar.usecase.recipe.manager.CreateRecipeInputBoundary;
import recipe.foodbar.usecase.recipe.manager.CreateRecipeInteractor;
import recipe.foodbar.usecase.recipe.manager.CreateRecipePresenter;
import recipe.foodbar.usecase.user.UserManager;
import recipe.foodbar.usecase.user.port.UserCreatorInputBoundary;
import recipe.foodbar.usecase.user.port.UserRepository;
import recipe.foodbar.usecase.userLogin.UserLogin;
import recipe.foodbar.usecase.userLogin.port.LoginRepositoryInterface;
import recipe.foodbar.usecase.userLogin.port.UserLoginInputBoundary;
import recipe.foodbar.usecase.userLogin.port.UserLoginOutputBoundary;
import recipe.foodbar.usecase.userLogout.UserLogout;
import recipe.foodbar.usecase.userLogout.port.UserLogoutInputBoundary;
import recipe.foodbar.usecase.userLogout.port.UserLogoutOutputBoundary;
import recipe.foodbar.usecase.recipe.port.RecipeRepository;

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
}
