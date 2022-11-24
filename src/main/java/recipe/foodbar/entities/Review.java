package recipe.foodbar.entities;

public class Review {
    private final String id;
    private final String recipeId;
    private static final int MAX_LENGTH = 300;
    private final String title;
    private final String text;
    private final User author;

    private Review(String id, String recipeId, String title, String text, User author) {
        this.id = id;
        this.recipeId = recipeId;
        this.title = title;
        this.text = text;
        this.author = author;
    }

    public static ReviewBuilder builder() {
        return new ReviewBuilder();
    }

    public String getId() {
        return id;
    }

    public String getRecipeId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public User getAuthor() {
        return author;
    }

    public int getMaxLength() { return MAX_LENGTH; }

    @Override
    public String toString() {
        return String.format("%s by %s: %s", title, author.getId(), text);
        // change getId() to getUsername() once arthur is done his stuff
    }

    public static class ReviewBuilder {
        private String id;
        private String recipeId;
        private String title;
        private String text;
        private User author;

        ReviewBuilder() {
        }

        public ReviewBuilder id(final String id) {
            this.id = id;
            return this;
        }

        public ReviewBuilder recipeId(final String id) {
            this.recipeId = id;
            return this;
        }

        public ReviewBuilder title(String title) {
            this.title = title;
            return this;
        }

        public ReviewBuilder text(String text) {
            this.text = text;
            return this;
        }

        public ReviewBuilder author(User author) {
            this.author = author;
            return this;
        }

        public Review build() {
            return new Review(id, recipeId, title, text, author);
        }
    }
}
