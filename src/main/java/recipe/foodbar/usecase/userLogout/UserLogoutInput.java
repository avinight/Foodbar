package recipe.foodbar.usecase.userLogout;

public class UserLogoutInput {
    private final String cookie;


    /**
     * Constructor for UserLogoutInput
     *
     * @param cookie String representation of the logged in cookie identifier
     */
    public UserLogoutInput(String cookie){
        this.cookie = cookie;
    }

    /**
     * Getter method for accessing the cookie
     *
     * @return the String for cookie
     */
    public String getCookie(){
        return this.cookie;
    }
}
