package recipe.foodbar.controller.dto;

import recipe.foodbar.entities.Review;
import recipe.foodbar.entities.User;

public class ReviewDTO {
    private String id;
    private String recipeId;
    private static final int MAX_LENGTH = 300;
    private String title;
    private String text;
    private User author;


    public static ReviewDTO toReviewDTO(final Review review) {
        var userWeb = new ReviewDTO();
        userWeb.setId(review.getId());
        userWeb.setRecipeId(review.getRecipeId());
        userWeb.setTitle(review.getTitle());
        userWeb.setText(review.getText());
        userWeb.setAuthor(review.getAuthor());
        return userWeb;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    public int getMaxLength() {
        return MAX_LENGTH;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Review toReview() {
        return Review.builder()
                .id(id)
                .recipeId(recipeId)
                .title(title)
                .text(text)
                .author(author)
                .build();
    }
}