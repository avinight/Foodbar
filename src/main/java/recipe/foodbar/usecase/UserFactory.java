package recipe.foodbar.usecase;
import recipe.foodbar.entities.RegisteredUser;


public class UserFactory extends InMemoryUserRepository{



    private UserFactory(){

    }

    /**
     * Constructor a  RegisteredUser object given the information
     *
     * @param username String representation for the username
     * @param password String representation for the password
     * @param first String representation for the firstname
     * @param last String representation for the lastname
     * @param email String representation for the email
     * @return the created RegisteredUser object
     */
    public static RegisteredUser createAccount(String username, String password,
                                               String first, String last, String email){
        RegisteredUser user = new RegisteredUser(username, password, first, last, email);
        UserFactory.create(user);
        return user;
        //code to add the user to the repository
        //
        //


    }



}