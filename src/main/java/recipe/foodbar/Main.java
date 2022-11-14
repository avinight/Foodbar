package recipe.foodbar;

import recipe.foodbar.controller.AccountController;
import recipe.foodbar.controller.AccountPresenter;
import recipe.foodbar.repository.InMemoryUserRepository;
import recipe.foodbar.usecase.*;

public class Main {
    public static void main(String[] args) {
        InMemoryUserRepository repo = new InMemoryUserRepository();
        System.out.println("Test Account creation");

        String username = "Arthur123";
        String password = "123";
        String firstName = "Arthur";
        String lastName = "dog";
        String passwordShadow = "123";
        String email = "a@gmail.com";
        AccountPresenter accountPresenter = new AccountPresenter();
        UserCreatorInputBoundary data = new UserManager(accountPresenter, repo);
        AccountController accountController = new AccountController(data);
        UserInputData user = accountController.create(username, password, passwordShadow, firstName, lastName, email);


        System.out.println(accountController.data.create(user));
        System.out.println(repo.findByUsername("Arthur123"));
        System.out.println(repo.existsByUsername("Arthur123"));

        System.out.println("**********************************************************************************");

        System.out.println("Test Account creation with one null entry");

        String username2 = "Arthur2";
        String password2 = "123";
        String firstName2 = null;
        String lastName2 = "dog";
        String passwordShadow2 = "123";
        String email2 = "a@gmail.com";
        UserInputData user2 = accountController.create(username2, password2, passwordShadow2,
                firstName2, lastName2, email2);


        System.out.println(accountController.data.create(user2));
        System.out.println(repo.findByUsername("Arthur2"));
        System.out.println(repo.existsByUsername("Arthur2"));

        System.out.println("**********************************************************************************");

        System.out.println("Test Account creation with two null entries");

        String username3 = "Arthur3";
        String password3 = "12345";
        String firstName3 = null;
        String lastName3 = null;
        String passwordShadow3 = "12345";
        String email3 = "dog@gmail.com";

        //Setup of a new in memory repository object

        UserInputData user3 = accountController.create(username3, password3, passwordShadow3,
                firstName3, lastName3, email3);

        //presenter receives this data and returns the Username, along with successful creation message

        //accountController.data.create(user);

        System.out.println(accountController.data.create(user3));
        System.out.println(repo.findByUsername("Arthur3"));
        System.out.println(repo.findAllUsers());
    }
}