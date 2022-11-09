package recipe.foodbar.config;

import recipe.foodbar.simple.InMemoryUserRepository;
import recipes.foodbar.encoder.Sha256PasswordEncoder;
import recipes.foodbar.jug.JugIdGenerator;
import recipes.foodbar.usecase.user.CreateUser;
import recipes.foodbar.usecase.user.FindUser;
import recipes.foodbar.usecase.user.LoginUser;
import recipes.foodbar.usecase.user.port.IdGenerator;
import recipes.foodbar.usecase.user.port.PasswordEncoder;
import recipes.foodbar.usecase.user.port.UserRepository;

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