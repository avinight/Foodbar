package recipe.foodbar.controller.dto;

import recipe.foodbar.entities.UserExample;

public class UserDTO {
    private String id;
    private String email;
    private String password;
    private String lastName;
    private String firstName;

    public static UserDTO toUserDTO(final UserExample userExample) {
        var userWeb = new UserDTO();
        userWeb.setId(userExample.getId());
        userWeb.setEmail(userExample.getEmail());
        // do not map password
        userWeb.setLastName(userExample.getLastName());
        userWeb.setFirstName(userExample.getFirstName());
        return userWeb;
    }

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

    public UserExample toUser() {
        return UserExample.builder()
                .email(email)
                .password(password)
                .lastName(lastName)
                .firstName(firstName)
                .build();
    }
}
