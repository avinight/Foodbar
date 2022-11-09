package recipes.foodbar.usecase.user;

import recipes.foodbar.entities.User;
import recipes.foodbar.usecase.user.exception.UserAlreadyExistsException;
import recipes.foodbar.usecase.user.port.IdGenerator;
import recipes.foodbar.usecase.user.port.PasswordEncoder;
import recipes.foodbar.usecase.user.port.UserRepository;
import recipes.foodbar.usecase.user.validator.UserValidator;

public final class CreateUser {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final IdGenerator idGenerator;

    public CreateUser(final UserRepository repository, final PasswordEncoder passwordEncoder, final IdGenerator idGenerator) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.idGenerator = idGenerator;
    }

    public User create(final User user) {
        UserValidator.validateCreateUser(user);
        if (repository.findByEmail(user.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException(user.getEmail());
        }
        User userToSave = User.builder()
                .id(idGenerator.generate())
                .email(user.getEmail())
                .password(passwordEncoder.encode(user.getEmail() + user.getPassword()))
                .lastName(user.getLastName())
                .firstName(user.getFirstName())
                .build();
        return repository.create(userToSave);
    }
}
