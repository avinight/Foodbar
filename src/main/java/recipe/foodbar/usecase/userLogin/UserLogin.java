package recipe.foodbar.usecase.userLogin;

import recipe.foodbar.usecase.user.port.IdGenerator;
import recipe.foodbar.usecase.user.port.UserRepositoryInterface;
import recipe.foodbar.usecase.userLogin.port.LoginRepositoryInterface;
import recipe.foodbar.usecase.userLogin.port.UserLoginInputBoundary;
import recipe.foodbar.usecase.userLogin.port.UserLoginOutputBoundary;


public class UserLogin implements UserLoginInputBoundary {

    private final UserLoginOutputBoundary output;
    private final UserRepositoryInterface userRepo;
    private final LoginRepositoryInterface loginRepo;

    private final IdGenerator generator;


    /**
     * Constructor for UserLogin
     *
     * @param output the UserLoginOutputBoundary interface object to be implemented by the presenter
     * @param userRepo the user repository to be used and kept record of
     * @param loginRepo the login repository to be used and kept record of
     * @param generator the IdGenrator used
     */
    public UserLogin(UserLoginOutputBoundary output, UserRepositoryInterface userRepo,
                     LoginRepositoryInterface loginRepo, IdGenerator generator) {
        this.output = output;
        this.userRepo = userRepo;
        this.loginRepo = loginRepo;
        this.generator = generator;

    }


    /**
     * Method of UserLogin that logs the user in
     *
     * @param input the UserLoginInput object containing all important information
     * @return the expected message through the output boundary
     */
    @Override
    public String login(UserLoginInput input) {
        String username = input.getUsername();
        String password = input.getPassword();

        UserLoginValidator userValidator = new UserLoginValidator(userRepo);

        if ((userValidator.fullEntries(username, password)) && (userValidator.validateExist(username))
                && userRepo.findByUsername(username).isPresent() &&
                userValidator.validatePassword(username, password)) {


            String token = this.generator.generate();
            loginRepo.add(userRepo.findByUsername(username).get(), token);

            return token;

        } else if (!(userValidator.fullEntries(username, password))) {
            return output.message("login Failed: Missing Entries");

        } else if (!(userRepo.existsByUsername(username))) {
            return output.message("login Failed: User Does Not Exist");
        } else {
            return output.message("login Failed: Invalid Password");
        }

    }

}