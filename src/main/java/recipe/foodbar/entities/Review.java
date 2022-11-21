package recipe.foodbar.entities;

import recipe.foodbar.entities.UserExample;

public class Review {
    public static final int MAX_LENGTH = 300;
    private final String title;
    private final String text;
    private final UserExample author;

    private Review(String title, String text, UserExample author) {
        this.title = title;
        this.text = text;
        this.author = author;
    }

    public static ReviewBuilder builder() {
        return new ReviewBuilder();
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public UserExample getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return String.format("%s by %s: %s", title, author.getId(), text);
        // change getId() to getUsername() once arthur is done his stuff
    }

    public static class ReviewBuilder {
        private String title;
        private String text;
        private UserExample author;

        ReviewBuilder() {
        }

        public ReviewBuilder title(String title) {
            this.title = title;
            return this;
        }

        public ReviewBuilder text(String text) {
            this.text = text;
            return this;
        }

        public ReviewBuilder author(UserExample author) {
            this.author = author;
            return this;
        }

        public Review build() {
            return new Review(title, text, author);
        }
    }
}
