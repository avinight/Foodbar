package recipe.foodbar.usecase.user_example;

import recipe.foodbar.entities.UserExample;
import recipe.foodbar.usecase.user_example.exception.UserAlreadyExistsException;
import recipe.foodbar.usecase.user_example.port.IdGenerator;
import recipe.foodbar.usecase.user_example.port.PasswordEncoder;
import recipe.foodbar.usecase.user_example.port.UserRepository;
import recipe.foodbar.usecase.user_example.validator.UserValidator;

public final class CreateUser {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final IdGenerator idGenerator;

    public CreateUser(final UserRepository repository, final PasswordEncoder passwordEncoder, final IdGenerator idGenerator) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.idGenerator = idGenerator;
    }

    public UserExample create(final UserExample userExample) {
        UserValidator.validateCreateUser(userExample);
        if (repository.findByEmail(userExample.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException(userExample.getEmail());
        }
        UserExample userExampleToSave = UserExample.builder()
                .id(idGenerator.generate())
                .email(userExample.getEmail())
                .password(passwordEncoder.encode(userExample.getEmail() + userExample.getPassword()))
                .lastName(userExample.getLastName())
                .firstName(userExample.getFirstName())
                .build();
        return repository.create(userExampleToSave);
    }
}
