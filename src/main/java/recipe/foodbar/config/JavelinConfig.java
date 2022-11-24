package recipe.foodbar.config;

import recipe.foodbar.encoder.sha256.Sha256PasswordEncoder;
import recipe.foodbar.id_generator.jug.JugIdGenerator;
import recipe.foodbar.repository.simpleDB.InMemoryUserRepository;
import recipe.foodbar.usecase.user_example.CreateUser;
import recipe.foodbar.usecase.user_example.FindUser;
import recipe.foodbar.usecase.user_example.LoginUser;
import recipe.foodbar.usecase.user_example.port.IdGenerator;
import recipe.foodbar.usecase.user_example.port.PasswordEncoder;
import recipe.foodbar.usecase.user_example.port.UserRepository;

public class JavelinConfig {
    private final UserRepository userRepository = new InMemoryUserRepository();
    private final IdGenerator idGenerator = new JugIdGenerator();
    private final PasswordEncoder passwordEncoder = new Sha256PasswordEncoder();
    private final CreateUser createUser = new CreateUser(userRepository, passwordEncoder, idGenerator);
    private final FindUser findUser = new FindUser(userRepository);
    private final LoginUser loginUser = new LoginUser(userRepository, passwordEncoder);

    public CreateUser createUser() {
        return createUser;
    }

    public FindUser findUser() {
        return findUser;
    }

    public LoginUser loginUser() {
        return loginUser;
    }
}
