import com.mongodb.client.MongoDatabase;
import org.junit.jupiter.api.Test;
import recipe.foodbar.controller.user.AccountController;
import recipe.foodbar.controller.user.AccountPresenter;
import recipe.foodbar.controller.user.login.UserLoginController;
import recipe.foodbar.controller.user.login.UserLoginPresenter;
import recipe.foodbar.controller.user.logout.UserLogoutController;
import recipe.foodbar.controller.user.logout.UserLogoutPresenter;
import recipe.foodbar.id_generator.jug.JugIdGenerator;
import recipe.foodbar.repository.mongoDB.repository.MongoUserRepository;
import recipe.foodbar.repository.simpleDB.InMemoryCookieRepository;
import recipe.foodbar.usecase.user.UserInputData;
import recipe.foodbar.usecase.user.UserManager;
import recipe.foodbar.usecase.commonport.IdGenerator;
import recipe.foodbar.usecase.user.port.UserCreatorInputBoundary;
import recipe.foodbar.usecase.userLogin.UserLogin;
import recipe.foodbar.usecase.userLogin.UserLoginInput;
import recipe.foodbar.usecase.userLogin.port.LoginRepositoryInterface;
import recipe.foodbar.usecase.userLogin.port.UserLoginInputBoundary;
import recipe.foodbar.usecase.userLogin.port.UserLoginOutputBoundary;
import recipe.foodbar.usecase.userLogout.UserLogout;
import recipe.foodbar.usecase.userLogout.UserLogoutInput;
import recipe.foodbar.usecase.userLogout.port.UserLogoutInputBoundary;
import recipe.foodbar.usecase.userLogout.port.UserLogoutOutputBoundary;

import static recipe.foodbar.repository.mongoDB.MongoDB.getMongoDB;

public class UserLogoutTest {

    public void accountCreationMethod(String username, String password, String passwordShadow, String email,
                                      MongoUserRepository repo, IdGenerator idGenerator) {

        AccountPresenter accountPresenterTwo = new AccountPresenter();
        UserCreatorInputBoundary data = new UserManager(accountPresenterTwo, repo, idGenerator);
        AccountController accountController = new AccountController(data);
        UserInputData user = accountController.create(username, password, passwordShadow, email);

        accountController.data.create(user);
    }

    @Test
    public void userLogoutSuccess(){
        final IdGenerator idGenerator = new JugIdGenerator();

        MongoDatabase db = getMongoDB();
        MongoUserRepository repo = new MongoUserRepository(db);
        LoginRepositoryInterface loginRepositoryInterface = new InMemoryCookieRepository();

        //Creating the user
        String username = "Frank98";
        String password = "godfather2";
        String passwordShadow = "godfather2";
        String email = "frank978@gmail.com";

        accountCreationMethod(username, password, passwordShadow, email, repo, idGenerator);

        //Logging in the user
        UserLoginOutputBoundary userLoginOutputBoundary = new UserLoginPresenter();
        UserLoginInputBoundary userLoginInputBoundary = new UserLogin(userLoginOutputBoundary, repo,
                loginRepositoryInterface, idGenerator);
        UserLoginController userLoginController = new UserLoginController(userLoginInputBoundary);
        UserLoginInput userLoginInput = userLoginController.create(username, password);
        String cookie = userLoginController.data.login(userLoginInput);


        //Calling the userLogout use case
        UserLogoutOutputBoundary userLogoutOutputBoundary = new UserLogoutPresenter();
        UserLogoutInputBoundary userLogoutInputBoundary = new UserLogout(userLogoutOutputBoundary,
                loginRepositoryInterface);
        UserLogoutController userLogoutController = new UserLogoutController(userLogoutInputBoundary);
        UserLogoutInput userLogoutInput = userLogoutController.create(cookie);
        String actual = userLogoutController.data.logout(userLogoutInput);
        String expected = "User Successfully Logged Out";
        assert actual.equals(expected);
    }

    @Test
    public void userAlreadyLoggedOut(){
        final IdGenerator idGenerator = new JugIdGenerator();

        MongoDatabase db = getMongoDB();
        MongoUserRepository repo = new MongoUserRepository(db);
        LoginRepositoryInterface loginRepositoryInterface = new InMemoryCookieRepository();

        //Creating the user
        String username = "Frank98";
        String password = "godfather2";
        String passwordShadow = "godfather2";
        String email = "frank978@gmail.com";

        accountCreationMethod(username, password, passwordShadow, email, repo, idGenerator);


        //Calling the userLogout use case
        String cookie = "24832943289";
        UserLogoutOutputBoundary userLogoutOutputBoundary = new UserLogoutPresenter();
        UserLogoutInputBoundary userLogoutInputBoundary = new UserLogout(userLogoutOutputBoundary,
                loginRepositoryInterface);
        UserLogoutController userLogoutController = new UserLogoutController(userLogoutInputBoundary);
        UserLogoutInput userLogoutInput = userLogoutController.create(cookie);
        String actual = userLogoutController.data.logout(userLogoutInput);
        String expected = "User Logout failed, User Already Logged Out";
        assert actual.equals(expected);

    }
}
