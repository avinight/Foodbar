package recipe.foodbar.android.foodbar.api.model;

import com.google.android.material.textfield.TextInputEditText;

public class UserLogin {
    public String username;
    public String password;

    public UserLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
