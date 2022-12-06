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
    @Builder.Default
    private ArrayList<User> following = new ArrayList<>();
    @Builder.Default
    private ArrayList<User> followers = new ArrayList<>();
}
