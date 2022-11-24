package recipe.foodbar.usecase.user_login;

public class UserLoginInput {

    private final String username;
    private final String password;

    public UserLoginInput(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

}
