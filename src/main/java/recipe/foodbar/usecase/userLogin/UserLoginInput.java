package recipe.foodbar.usecase.userLogin;

public class UserLoginInput {

    private final String username;
    private final String password;


    /**
     * Constructor for UserLoginInput object
     *
     * @param username String representation of username
     * @param password String representation of password
     */
    public UserLoginInput(String username, String password) {
        this.username = username;
        this.password = password;
    }


    /**
     * Getter for username
     *
     * @return String representation of the username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Getter for password
     *
     * @return String representation of the password
     */
    public String getPassword() {
        return this.password;
    }

}