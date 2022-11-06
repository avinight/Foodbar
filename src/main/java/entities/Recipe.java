package entities;

import java.util.Date;

public class Recipe {
    private String title;
    // private User author;
    private String[] instructions;
    private String cuisine;
    private int likes;
    private int dislikes;
    private String[] dietaryRestrictions;
    private Date dateCreated;
    // private Review[] reviews;
    // private Ingredient ingredients;

    // TODO: Constructor doesn't exist as we may be using a factory- look into how this will work
    // TODO: Review, User, and Ingredient classes yet to exist- need to create those so that attributes of this class can be
    //  added correctly
    // TODO: Implement the Shareable interface when that is created, and add the associated Share method
    // TODO: Likes and Dislikes need to be tracked on a per-user-like/dislike basis and not simply iterated or
    //  deiterated within the Recipe object

    public String getTitle() {
        return title;
    }

//    public User getAuthor() {
//        return author;
//    }

    public String[] getInstructions() {
        return instructions;
    }

    public void like() {
        likes += 1;
    }

    public void unlike() {
        likes -= 1;
    }

    public void undislike() {
        dislikes -=1 ;
    }

    public void dislike() {
        dislikes += 1;
    }

    public int getRating() {
        return likes - dislikes;
    }

    public String[] getDietaryRestrictions() {
        return dietaryRestrictions;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void addReview(Review newReview) {
        ...
    }


}
