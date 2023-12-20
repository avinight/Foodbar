package foodbar.controller.dto;

import foodbar.entities.Review;
import foodbar.entities.User;

public class ReviewDTO {
    private static final int MAX_LENGTH = 300;
    private String recipeId;
    private String title;
    private String text;
    private User author;


    public static ReviewDTO toReviewDTO(final Review review) {
        var userWeb = new ReviewDTO();
        userWeb.setRecipeId(review.getRecipeId());
        userWeb.setTitle(review.getTitle());
        userWeb.setText(review.getText());
        userWeb.setAuthor(review.getAuthor());
        return userWeb;
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
                .recipeId(recipeId)
                .title(title)
                .text(text)
                .author(author)
                .build();
    }
}