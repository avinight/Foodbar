package app.foodbar.api.model;

public class UserRegister {
    public String username;
    public String password;
    public String passwordShadow;
    public String email;

    public UserRegister(String username, String password, String passwordShadow, String email) {
        this.username = username;
        this.password = password;
        this.passwordShadow = passwordShadow;
        this.email = email;
    }
}
