package foodbar.usecase.userLogin;

import foodbar.usecase.user.port.UserRepository;
import foodbar.usecase.userLogin.port.LoginRepositoryInterface;
import foodbar.usecase.userLogin.port.UserLoginInputBoundary;
import foodbar.usecase.userLogin.port.UserLoginOutputBoundary;


public class UserLogin implements UserLoginInputBoundary {

    private final UserLoginOutputBoundary output;
    private final UserRepository userRepo;
    private final LoginRepositoryInterface loginRepo;


    /**
     * Constructor for UserLogin
     *
     * @param output the UserLoginOutputBoundary interface object to be implemented by the presenter
     * @param userRepo the user repository to be used and kept record of
     * @param loginRepo the login repository to be used and kept record of
     */
    public UserLogin(UserLoginOutputBoundary output, UserRepository userRepo,
                     LoginRepositoryInterface loginRepo) {
        this.output = output;
        this.userRepo = userRepo;
        this.loginRepo = loginRepo;
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


            String token = userRepo.findByUsername(username).get().getId();
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