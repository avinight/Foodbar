package recipe.foodbar.usecase.user_logout;

public class UserLogoutInput {
    private String cookie;


    /**
     * Constructor for UserLogoutInput
     *
     * @param cookie String representation of the logged in cookie identifier
     */
    UserLogoutInput(String cookie) {
        this.cookie = cookie;
    }

    /**
     * Getter method for accessing the cookie
     *
     * @return the String for cookie
     */
    public String getCookie() {
        return this.cookie;
    }
}
