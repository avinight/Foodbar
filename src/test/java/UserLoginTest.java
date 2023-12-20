import com.mongodb.client.MongoDatabase;
import org.junit.jupiter.api.Test;
import foodbar.controller.user.AccountController;
import foodbar.controller.user.AccountPresenter;
import foodbar.controller.user.login.UserLoginController;
import foodbar.controller.user.login.UserLoginPresenter;
import foodbar.entities.User;
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


import static foodbar.repository.mongoDB.MongoDB.getMongoDB;

public class UserLoginTest {
    public void accountCreationMethod(String username, String password, String passwordShadow, String email,
                                      MongoUserRepository repo, IdGenerator idGenerator) {

        AccountPresenter accountPresenterTwo = new AccountPresenter();
        UserCreatorInputBoundary data = new UserManager(accountPresenterTwo, repo, idGenerator);
        AccountController accountController = new AccountController(data);
        //UserInputData user = accountController.create(username, password, passwordShadow, email);

        accountController.create(username, password, passwordShadow, email);
    }

    @Test
    public void loginCheck() {

        final IdGenerator idGenerator = new JugIdGenerator();

        MongoDatabase db = getMongoDB();
        MongoUserRepository repo = new MongoUserRepository(db);
        LoginRepositoryInterface loginRepositoryInterface = new InMemoryCookieRepository();

        String username = "Frank98";
        String password = "godfather2";
        String passwordShadow = "godfather2";
        String email = "frank978@gmail.com";

        UserLoginOutputBoundary userLoginOutputBoundary = new UserLoginPresenter();
        accountCreationMethod(username, password, passwordShadow, email, repo, idGenerator);
        UserLoginInputBoundary userLoginInputBoundary = new UserLogin(userLoginOutputBoundary, repo, loginRepositoryInterface);
        UserLoginController userLoginController = new UserLoginController(userLoginInputBoundary);
        UserLoginInput userLoginInput = userLoginController.login(username, password);
        String cookie = userLoginController.data.login(userLoginInput);

        System.out.println(loginRepositoryInterface.findByCookie(cookie));
        System.out.println(repo.findByUsername("Frank98"));

        //For this particular case we know the user is added to the repository
        if (repo.findByUsername("Frank98").isEmpty()) {
            System.out.println("User Account Creation Failed.");
            assert false;
        } else if (loginRepositoryInterface.findByCookie(cookie).isEmpty()) {
            System.out.println("Login Repository Process has failed.");
            assert false;
        } else {
            User actual = repo.findByUsername("Frank98").get();
            User expected = repo.findByUsername("Frank98").get();
            assert actual.equals(expected);
        }

    }

    @Test
    public void loginFailMissingEntries() {

        final IdGenerator idGenerator = new JugIdGenerator();

        MongoDatabase db = getMongoDB();
        MongoUserRepository repo = new MongoUserRepository(db);
        LoginRepositoryInterface loginRepositoryInterface = new InMemoryCookieRepository();

        String username = "Frank99";
        String password = "godfather2";
        String passwordShadow = "godfather2";
        String email = "frank978@gmail.com";

        UserLoginOutputBoundary userLoginOutputBoundary = new UserLoginPresenter();
        accountCreationMethod(username, password, passwordShadow, email, repo, idGenerator);
        UserLoginInputBoundary userLoginInputBoundary = new UserLogin(userLoginOutputBoundary, repo, loginRepositoryInterface);
        UserLoginController userLoginController = new UserLoginController(userLoginInputBoundary);
        UserLoginInput userLoginInput = userLoginController.login(null, null);
        String actual = userLoginController.data.login(userLoginInput);
        String expected = "login Failed: Missing Entries";

        assert actual.equals(expected);
    }

    @Test
    public void loginFailedPasswordInvalid() {

        final IdGenerator idGenerator = new JugIdGenerator();

        MongoDatabase db = getMongoDB();
        MongoUserRepository repo = new MongoUserRepository(db);
        LoginRepositoryInterface loginRepositoryInterface = new InMemoryCookieRepository();

        String username = "Frank100";
        String password = "godfather2";
        String passwordShadow = "godfather2";
        String email = "frank978@gmail.com";

        UserLoginOutputBoundary userLoginOutputBoundary = new UserLoginPresenter();
        accountCreationMethod(username, password, passwordShadow, email, repo, idGenerator);
        UserLoginInputBoundary userLoginInputBoundary = new UserLogin(userLoginOutputBoundary, repo, loginRepositoryInterface);
        UserLoginController userLoginController = new UserLoginController(userLoginInputBoundary);
        UserLoginInput userLoginInput = userLoginController.login("Frank100", "Scarface");
        String actual = userLoginController.data.login(userLoginInput);
        String expected = "login Failed: Invalid Password";

        assert actual.equals(expected);
    }

}
