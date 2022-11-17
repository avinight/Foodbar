package recipe.foodbar.entities;

public class RegisteredUser {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;


    public RegisteredUser(final String username, final String password,
                          final String first, final String last, final String email) {
        this.username = username;
        this.password = password;
        this.firstName = first;
        this.lastName = last;
        this.email = email;


    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){return this.lastName;}
    public String getEmail(){
        return this.email;
    }



    @Override
    public String toString(){
        return "User{Username = " + this.username + " | " + "Password = " +
                this.password + " | " + "Email = " + this.email + " | " +
                "First name = " + this.firstName +
                " | " + "Last name = " + this.lastName + " | " + "}";}

}
