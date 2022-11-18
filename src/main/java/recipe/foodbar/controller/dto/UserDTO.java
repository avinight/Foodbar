package recipe.foodbar.controller.dto;

import recipe.foodbar.entities.User;

public class UserDTO {
    private String id;
    private String email;
    private String password;
    private String lastName;
    private String firstName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public User toUser() {
        return User.builder()
                .email(email)
                .password(password)
                .lastName(lastName)
                .firstName(firstName)
                .build();
    }

    public static UserDTO toUserDTO(final User user) {
        var userWeb = new UserDTO();
        userWeb.setId(user.getId());
        userWeb.setEmail(user.getEmail());
        // do not map password
        userWeb.setLastName(user.getLastName());
        userWeb.setFirstName(user.getFirstName());
        return userWeb;
    }
}