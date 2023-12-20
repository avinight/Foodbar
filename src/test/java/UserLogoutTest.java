import com.mongodb.client.MongoDatabase;
import org.junit.jupiter.api.Test;
import foodbar.controller.user.AccountController;
import foodbar.controller.user.AccountPresenter;
import foodbar.controller.user.login.UserLoginController;
import foodbar.controller.user.login.UserLoginPresenter;
import foodbar.controller.user.logout.UserLogoutController;
import foodbar.controller.user.logout.UserLogoutPresenter;
import foodbar.id_generator.jug.JugIdGenerator;
import foodbar.repository.mongoDB.repository.MongoUserRepository;
import foodbar.repository.simpleDB.InMemoryCookieRepository;
import foodbar.usecase.user.UserManager;
import foodbar.usecase.commonport.IdGenerator;
import foodbar.usecase.user.port.UserCreatorInputBoundary;
import foodbar.usecase.userLogin.UserLogin;
import foodbar.usecase.userLogin.UserLoginInput;
import foodbar.usecase.userLogin.port.LoginRepositoryInterface;
import foodbar.usecase.userLogin.port.UserLoginInputBoundary;
import foodbar.usecase.userLogin.port.UserLoginOutputBoundary;
import foodbar.usecase.userLogout.UserLogout;
import foodbar.usecase.userLogout.UserLogoutInput;
import foodbar.usecase.userLogout.port.UserLogoutInputBoundary;
import foodbar.usecase.userLogout.port.UserLogoutOutputBoundary;

import static foodbar.repository.mongoDB.MongoDB.getMongoDB;

public class UserLogoutTest {

    public void accountCreationMethod(String username, String password, String passwordShadow, String email,
                                      MongoUserRepository repo, IdGenerator idGenerator) {

        AccountPresenter accountPresenterTwo = new AccountPresenter();
        UserCreatorInputBoundary data = new UserManager(accountPresenterTwo, repo, idGenerator);
        AccountController accountController = new AccountController(data);
        //UserInputData user = accountController.create(username, password, passwordShadow, email);

        accountController.create(username, password, passwordShadow, email);
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
        UserLoginInputBoundary userLoginInputBoundary = new UserLogin(userLoginOutputBoundary, repo, loginRepositoryInterface);
        UserLoginController userLoginController = new UserLoginController(userLoginInputBoundary);
        UserLoginInput userLoginInput = userLoginController.login(username, password);
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
