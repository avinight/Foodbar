package recipe.foodbar.usecase.user_login;

import recipe.foodbar.usecase.user.port.UserRepositoryInterface;
import recipe.foodbar.usecase.user_example.port.IdGenerator;
import recipe.foodbar.usecase.user_login.port.LoginRepositoryInterface;
import recipe.foodbar.usecase.user_login.port.UserLoginInputBoundary;
import recipe.foodbar.usecase.user_login.port.UserLoginOutputBoundary;


public class UserLogin implements UserLoginInputBoundary {

    private final UserLoginOutputBoundary output;
    private final UserRepositoryInterface userRepo;
    private final LoginRepositoryInterface loginRepo;

    private final IdGenerator generator;


    public UserLogin(UserLoginOutputBoundary output, UserRepositoryInterface userRepo,
                     LoginRepositoryInterface loginRepo, IdGenerator generator){
        this.output = output;
        this.userRepo = userRepo;
        this.loginRepo = loginRepo;
        this.generator = generator;

    }


    @Override
    public String login(UserLoginInput input){
        String username = input.getUsername();
        String password = input.getPassword();

        UserLoginValidator userValidator = new UserLoginValidator(userRepo);

        if ((userValidator.fullEntries(username, password)) && (userValidator.validateExist(username))
        && userRepo.getByUsername(username).isPresent()){


            String token = this.generator.generate();
            loginRepo.add(userRepo.getByUsername(username).get(), token);

            return token;

        } else if (!(userValidator.fullEntries(username, password))) {
            return output.message("login Failed: Missing Entries");
        } else {
            return output.message("login Failed: User Does Not Exist");
        }

    }

}
