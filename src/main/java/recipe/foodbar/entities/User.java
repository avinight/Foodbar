package recipe.foodbar.entities;

import lombok.*;

import java.util.ArrayList;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@ToString
public class User {

    private String id;
    private String username;
    private String password;
    private String email;
    private ArrayList<User> following;
    private ArrayList<User> followers;
}
