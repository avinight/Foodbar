/*
Class for the input data passed through to the usecase interactor of usercreation
 */
package recipe.foodbar.usecase;

public class UserInputData{
    private String username;
    private String password;
    private String passwordShadow;
    private String email;
    private String firstName;
    private String lastName;

    /**
     * Constructor for UserInputData
     *
     * @param username String representing the username
     * @param password String representing the password
     * @param passwordShadow String representing the passwordShadow
     * @param first String representing the firstname
     * @param last String representing the lastname
     * @param email String representing the email
     */

    public UserInputData(String username, String password, String passwordShadow, String first, String last, String email) {
        this.username = username;
        this.password = password;
        this.passwordShadow = passwordShadow;
        this.firstName = first;
        this.lastName = last;
        this.email = email;

    }


    /**
     * getter function for the username
     *
     * @return the username variable
     */
    public String getUsername(){
        return this.username;
    }

    /**
     * getter function for the password
     *
     * @return the password variable
     */
    public String getPassword(){
        return this.password;
    }

    /**
     * getter function for the passwordShadow
     *
     * @return the passwordShadow variable
     */
    public String getPasswordShadow(){return this.passwordShadow;}
    public String getFirstName(){
        return this.firstName;
    }

    /**
     * getter function for the lastname
     *
     * @return the lastName variable
     */
    public String getLastName(){return this.lastName;}
    public String getEmail(){
        return this.email;
    }
}
