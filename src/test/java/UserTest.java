import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import recipe.foodbar.controller.user.AccountController;
import recipe.foodbar.controller.user.AccountPresenter;
import recipe.foodbar.entities.User;
import recipe.foodbar.id_generator.jug.JugIdGenerator;
import recipe.foodbar.repository.simpleDB.InMemoryUserRepository;
import recipe.foodbar.usecase.user.UserInputData;
import recipe.foodbar.usecase.user.UserManager;
import recipe.foodbar.usecase.user.port.IdGenerator;
import recipe.foodbar.usecase.user.port.UserCreatorInputBoundary;

public class UserTest {

    public String accountCreationMethod(String username, String password, String passwordShadow,
                                        String firstName, String lastName, String email,
                                        recipe.foodbar.repository.simpleDB.InMemoryUserRepository repo, IdGenerator idGenerator){

        AccountPresenter accountPresenterTwo = new AccountPresenter();
        UserCreatorInputBoundary data = new UserManager(accountPresenterTwo, repo, idGenerator);
        AccountController accountController = new AccountController(data);
        UserInputData user = accountController.create(username, password, passwordShadow, firstName, lastName, email);

        return accountController.data.create(user);
    }

    @Test
    public void usernameDuplicate(){
        InMemoryUserRepository repo = new InMemoryUserRepository();
        final IdGenerator idGenerator = new JugIdGenerator();


        String username = "Frank97";
        String password = "godfather2";
        String firstName = "Frank";
        String lastName = "Castle";
        String passwordShadow = "godfather2";
        String email = "frank978@gmail.com";

        String usernameTwo = "Frank97";
        String passwordTwo = "godfather2";
        String firstNameTwo = "Frank";
        String lastNameTwo = "Castle";
        String passwordShadowTwo = "godfather2";
        String emailTwo = "frank978@gmail.com";

        accountCreationMethod(username, password, passwordShadow, firstName, lastName, email, repo, idGenerator);



        String actual = "Username is taken";
        String expected = accountCreationMethod(usernameTwo, passwordTwo,
                passwordShadowTwo, firstNameTwo, lastNameTwo, emailTwo, repo, idGenerator);
        assert actual.equals(expected);
    }

    @Test
    public void passwordsDoNotMatch(){
        InMemoryUserRepository repo = new InMemoryUserRepository();
        final IdGenerator idGenerator = new JugIdGenerator();


        String username = "Frank97";
        String password = "godfather2";
        String firstName = "Frank";
        String lastName = "Castle";
        String passwordShadow = "godfather3";
        String email = "frank978@gmail.com";


        String actual = "Passwords do not match";
        String expected = accountCreationMethod(username, password, passwordShadow,
                firstName, lastName, email, repo, idGenerator);
        assert actual.equals(expected);
    }

    @Test
    public void firstNameMissing(){
        InMemoryUserRepository repo = new InMemoryUserRepository();
        final IdGenerator idGenerator = new JugIdGenerator();


        String username = "Frank97";
        String password = "godfather2";
        String firstName = null;
        String lastName = "Castle";
        String passwordShadow = "godfather2";
        String email = "frank978@gmail.com";


        String actual = "First Name field is empty";
        String expected = accountCreationMethod(username, password, passwordShadow, firstName,
                lastName, email, repo, idGenerator);
        System.out.println(expected);
        assert actual.equals(expected);
    }

    @Test
    public void allNullEntries(){
        InMemoryUserRepository repo = new InMemoryUserRepository();
        final IdGenerator idGenerator = new JugIdGenerator();




        String actual = "Username field is empty, Password field is empty, Password Confirmation field is empty, " +
                "First Name field is empty, Last Name field is empty, Email field is empty";
        String expected = accountCreationMethod(null, null, null, null,
                null, null, repo, idGenerator);
        System.out.println(expected);
        assert actual.equals(expected);
    }





}
