package recipe.foodbar.entities;

import java.util.ArrayList;

public class UserExample {

    private final String id;
    private final String email;
    private final String password;
    private final String lastName;
    private final String firstName;

    private final ArrayList<UserExample> following;
    private final ArrayList<UserExample> followers;

    private UserExample(final String id, final String email, final String password, final String lastName, final String firstName) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.followers = new ArrayList<UserExample>();
        this.following = new ArrayList<UserExample>();
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public ArrayList<UserExample> getFollowers() {
        return followers;
    }

    public ArrayList<UserExample> getFollowing() {
        return following;
    }

    public void follow(UserExample userExampleToFollow) {
        this.following.add(userExampleToFollow);
    }

    public void addFollower(UserExample follower) {
        this.followers.add(follower);
    }

    public void unFollow(UserExample userExampleToFollow) {
        this.following.remove(userExampleToFollow);
    }

    public void removeFollower(UserExample follower) {
        this.followers.remove(follower);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }

    public static class UserBuilder {
        private String id;
        private String email;
        private String password;
        private String lastName;
        private String firstName;
        private ArrayList<UserExample> following;
        private ArrayList<UserExample> followers;

        UserBuilder() {
        }

        public UserBuilder id(final String id) {
            this.id = id;
            return this;
        }

        public UserBuilder email(final String email) {
            this.email = email;
            return this;
        }

        public UserBuilder password(final String password) {
            this.password = password;
            return this;
        }

        public UserBuilder lastName(final String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder firstName(final String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder followers() {
            this.followers = new ArrayList<UserExample>();
            return this;
        }

        public UserBuilder following() {
            this.following = new ArrayList<UserExample>();
            return this;
        }

        public UserExample build() {
            return new UserExample(id, email, password, lastName, firstName);
        }
    }
}
