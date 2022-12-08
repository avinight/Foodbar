package recipe.foodbar.config;

import com.mongodb.client.MongoDatabase;
import recipe.foodbar.controller.user.AccountController;
import recipe.foodbar.controller.user.AccountPresenter;
import recipe.foodbar.id_generator.jug.JugIdGenerator;
import recipe.foodbar.repository.mongoDB.MongoDB;
import recipe.foodbar.repository.mongoDB.repository.MongoUserRepository;
import recipe.foodbar.usecase.commonport.IdGenerator;
import recipe.foodbar.usecase.user.UserManager;
import recipe.foodbar.usecase.user.port.UserCreatorInputBoundary;
import recipe.foodbar.usecase.user.port.UserRepository;

public class JavelinConfig {
    MongoDatabase db = MongoDB.getMongoDB();
    private final UserRepository userRepository = new MongoUserRepository(db);
    private final IdGenerator idGenerator = new JugIdGenerator();
//    private final PasswordEncoder passwordEncoder = new Sha256PasswordEncoder();

    AccountPresenter accountPresenterTwo = new AccountPresenter();
    UserCreatorInputBoundary data = new UserManager(accountPresenterTwo, userRepository, idGenerator);
    AccountController accountController = new AccountController(data);
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
}
