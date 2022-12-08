package recipe.foodbar.config;

import com.mongodb.client.MongoDatabase;
import recipe.foodbar.controller.user.AccountController;
import recipe.foodbar.controller.user.AccountPresenter;
import recipe.foodbar.controller.user.login.UserLoginController;
import recipe.foodbar.controller.user.login.UserLoginPresenter;
import recipe.foodbar.controller.user.logout.UserLogoutController;
import recipe.foodbar.controller.user.logout.UserLogoutPresenter;
import recipe.foodbar.id_generator.jug.JugIdGenerator;
import recipe.foodbar.repository.mongoDB.MongoDB;
import recipe.foodbar.repository.mongoDB.repository.MongoUserRepository;
import recipe.foodbar.repository.simpleDB.InMemoryCookieRepository;
import recipe.foodbar.usecase.commonport.IdGenerator;
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

public class JavelinConfig {
    MongoDatabase db = MongoDB.getMongoDB();
    private final UserRepository userRepository = new MongoUserRepository(db);
    LoginRepositoryInterface loggedInRepo = new InMemoryCookieRepository();
    private final IdGenerator idGenerator = new JugIdGenerator();
//    private final PasswordEncoder passwordEncoder = new Sha256PasswordEncoder();

    AccountPresenter accountPresenter = new AccountPresenter();
    UserLoginOutputBoundary userLoginOutputBoundary = new UserLoginPresenter();
    UserLogoutOutputBoundary userLogoutOutputBoundary = new UserLogoutPresenter();
    UserCreatorInputBoundary data = new UserManager(accountPresenter, userRepository, idGenerator);
    UserLoginInputBoundary userLoginInputBoundary = new UserLogin(userLoginOutputBoundary, userRepository, loggedInRepo);
    AccountController accountController = new AccountController(data);
    UserLoginController userLoginController = new UserLoginController(userLoginInputBoundary);
    UserLogoutInputBoundary userLogoutInputBoundary = new UserLogout(userLogoutOutputBoundary, loggedInRepo);
    UserLogoutController userLogoutController = new UserLogoutController(userLogoutInputBoundary);
//    private final FindUser findUser = new FindUser(userRepository);
//    private final LoginUser loginUser = new LoginUser(userRepository, passwordEncoder);
//
//    public CreateUser createUser() {
//        return createUser;
//    }
//
//    public FindUser findUser() {
//        return findUser;
//    }
//
//    public LoginUser loginUser() {
//        return loginUser;
//    }

    public AccountController getAccountController() {
        return accountController;
    }

    public UserLoginController getUserLoginController() {
        return userLoginController;
    }

    public UserLogoutController getUserLogoutController() {
        return userLogoutController;
    }
}
