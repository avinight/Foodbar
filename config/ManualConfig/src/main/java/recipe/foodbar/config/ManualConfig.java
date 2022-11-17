package recipe.foodbar.config;

import recipe.foodbar.simple.InMemoryUserRepository;
import recipe.foodbar.encoder.Sha256PasswordEncoder;
import recipe.foodbar.jug.JugIdGenerator;
import recipe.foodbar.usecase.user.CreateUser;
import recipe.foodbar.usecase.user.FindUser;
import recipe.foodbar.usecase.user.LoginUser;
import recipe.foodbar.usecase.user.port.IdGenerator;
import recipe.foodbar.usecase.user.port.PasswordEncoder;
import recipe.foodbar.usecase.user.port.UserRepository;

public class ManualConfig {
    private final UserRepository userRepository = new InMemoryUserRepository();
    private final IdGenerator idGenerator = new JugIdGenerator();
    private final PasswordEncoder passwordEncoder = new Sha256PasswordEncoder();

    public CreateUser createUser() {
        return new CreateUser(userRepository, passwordEncoder, idGenerator);
    }

    public FindUser findUser() {
        return new FindUser(userRepository);
    }

    public LoginUser loginUser() {
        return new LoginUser(userRepository, passwordEncoder);
    }
}