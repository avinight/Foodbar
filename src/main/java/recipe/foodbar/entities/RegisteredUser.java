package recipe.foodbar.entities;

import java.util.ArrayList;

public class RegisteredUser {

    private String id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;

    private ArrayList<User> following;

    private ArrayList<User> followers;


    public RegisteredUser(final String id, final String username, final String password,
                          final String first, final String last, final String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = first;
        this.lastName = last;
        this.email = email;
        this.following = new ArrayList<User>();
        this.followers = new ArrayList<User>();


    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public ArrayList<User> getFollowing() {
        return following;
    }

    public ArrayList<User> getFollowers() {
        return followers;
    }

    public void setFollowing(ArrayList<User> following) {
        this.following = following;
    }

    public void setFollowers(ArrayList<User> followers) {
        this.followers = followers;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", following='" + following + '\'' +
                ", followers='" + followers + '\'' +
                '}';
    }

}
