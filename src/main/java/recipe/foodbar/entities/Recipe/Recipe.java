package recipe.foodbar.entities.Recipe;

import recipe.foodbar.entities.Cuisine;
import recipe.foodbar.entities.Ingredient;
import recipe.foodbar.entities.Review;
import recipe.foodbar.entities.User;

import java.util.ArrayList;
import java.util.Date;

/**
 * The recipe class.
 */
public class Recipe {
    private final String id;
    private String title;
    private String userId;
    private float portionSize;
    private String[] instructions;
    private Cuisine cuisine;
    private String[] dietaryRestrictions;
    private final Date dateCreated;
    private final ArrayList<Ingredient> ingredients;
    private final ArrayList<String> likers;
    private final ArrayList<String> dislikers;
    private final ArrayList<Review> reviews;


    /**
     * Constructs a Recipe with id, title, author, portionSize, instructions, cuisine, dietaryRestrictions, dateCreated,
     * ingredients, and reviews.
     *
     * @param id                  The id of the recipe.
     * @param title               The title of the recipe.
     * @param userId              The author of the recipe.
     * @param portionSize         The portion size of the recipe.
     * @param instructions        The instructions of the recipe.
     * @param cuisine             The cuisine of the recipe.
     * @param dietaryRestrictions The dietary restrictions of the recipe.
     * @param dateCreated         The date the recipe was created.
     * @param ingredients         The ingredients of the recipe.
     * @param likers              The ID of Users who have liked this recipe.
     * @param dislikers           The ID of Users who have disliked this recipe.
     * @param reviews             The reviews of the recipe.
     */
    public Recipe(String id, String title, final String userId, float portionSize, String[] instructions,
           Cuisine cuisine, String[] dietaryRestrictions, final Date dateCreated,
           ArrayList<Ingredient> ingredients, ArrayList<String> likers, ArrayList<String> dislikers,
           ArrayList<Review> reviews) {
        this.id = id;
        this.title = title;
        this.userId = userId;
        this.portionSize = portionSize;
        this.instructions = instructions;
        this.cuisine = cuisine;
        this.dietaryRestrictions = dietaryRestrictions;
        this.dateCreated = dateCreated;
        this.ingredients = ingredients;
        this.likers = likers;
        this.dislikers = dislikers;
        this.reviews = reviews;
    }

    public static RecipeBuilder builder() {
        return new RecipeBuilder();
    }

    /**
     * Returns the id of the recipe.
     *
     * @return the id of the recipe.
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the title of the recipe.
     *
     * @return the title of the recipe.
     */
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the author of the recipe.
     *
     * @return the author of the recipe.
     */
    public String getAuthor() {
        return userId;
    }

    public void setAuthor(String id) {
        this.userId = id;
    }

    /**
     * Returns the portion size of the recipe.
     *
     * @return the portionSize of the recipe.
     */
    public float getPortionSize() {
        return portionSize;
    }

    /**
     * Sets the portionSize and
     * modifies each ingredient based on the portionSize multiplier.
     *
     * @param portionSize The portion size of the Recipe.
     */
    public void modifyIngredients(int portionSize) {
        this.portionSize = portionSize;
        for (Ingredient ingredient : ingredients) {
            ingredient.setSize(portionSize * ingredient.getSize());
        }
    }

    /**
     * Returns the instructions of the recipe.
     *
     * @return the instructions of the recipe.
     */
    public String[] getInstructions() {
        return instructions;
    }

    public void setInstructions(String[] i) {
        this.instructions = i;
    }

    /**
     * Returns the cuisine of the recipe.
     *
     * @return the cuisine of the recipe.
     */
    public Cuisine getCuisine() {
        return cuisine;
    }

    public void setCuisine(Cuisine cuisine) { this.cuisine = cuisine; }
    /**
     * Returns the rating of the recipe.
     *
     * @return int likers.size() - dislikers.size()
     */
    public int getRating() {
        return likers.size() - dislikers.size();
    }

    /**
     * Returns the likes of the recipe.
     *
     * @return int likers.size
     */
    public int getLikes() {
        return likers.size();
    }

    /**
     * Returns the dislikes of the recipe.
     *
     * @return int dislikers.size
     */
    public int getDislikes() {
        return dislikers.size();
    }

    /**
     * Adds the voter to the list of Users who like this recipe. If the voter has previously liked or disliked this recipe,
     * remove that like or dislike before liking this recipe.
     *
     * @param voterID User who liked this recipe
     */
    public void like(String voterID) {
        if (this.likers.contains(voterID)) {
            this.likers.remove(voterID);
        } else if (this.dislikers.contains(voterID)) {
            this.dislikers.remove(voterID);
            this.likers.add(voterID);
        }
        else {
            this.likers.add(voterID);
        }
    }

    /**
     * Adds the voter to the list of Users who dislike this recipe. If the voter has previously liked or disliked this recipe,
     * remove that like or dislike before disliking this recipe.
     *
     * @param voterID User who disliked this recipe
     */
    public void dislike(String voterID) {
        if (this.dislikers.contains(voterID)) {
            this.dislikers.remove(voterID);
        } else if (this.likers.contains(voterID)) {
            this.likers.remove(voterID);
            this.dislikers.add(voterID);
        }
        else {
            this.dislikers.add(voterID);
        }
    }

    /**
     * Returns this recipe's likers
     *
     * @return ArrayList<User>
     */
    public ArrayList<String> getLikers() {
        return likers;
    }

    /**
     * Returns this recipe's dislikers
     *
     * @return ArrayList<User>
     */
    public ArrayList<String> getDislikers() {
        return dislikers;
    }

    /**
     * Returns the dietary restrictions of the recipe.
     *
     * @return String[]
     */
    public String[] getDietaryRestrictions() {
        return dietaryRestrictions;
    }

    /**
     * Sets the dietary restrictions of the recipe.
     *
     * @param dr    Dietary Restrictions.
     */
    public void setDietaryRestrictions(String[] dr) {
        this.dietaryRestrictions = dr;
    }

    /**
     * Returns the date this recipe was created.
     *
     * @return Date
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    /**
     * Returns this recipe's ingredients.
     *
     * @return ArrayList<Ingredient>
     */
    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }


    /**
     * Returns this recipe's reviews.
     *
     * @return ArrayList<Review>
     */
    public ArrayList<Review> getReviews() {
        return reviews;
    }


    /**
     * Adds new ingredients to the ingredients ArrayList.
     *
     * @param ingredient An ingredient.
     */
    public boolean addIngredient(Ingredient ingredient) {
        if (this.ingredients.contains(ingredient)) {
            return true;
        } else {
            this.ingredients.add(ingredient);
            return false;
        }
    }

    /**
     * Removes ingredient from ingredients ArrayList.
     *
     * @param ingredient An ingredient.
     */
    public boolean removeIngredient(Ingredient ingredient) {
        if (this.ingredients.contains(ingredient)) {
            this.ingredients.remove(ingredient);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Return a string representation of this Recipe.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Recipe{" +
                "id = " + id + '\'' +
                ", title = '" + title + '\'' +
                ", authorID = '" + userId + '\'' +
                ", cuisine = '" + cuisine.toString() + '\'' +
                ", likes = '" + this.getLikes() + '\'' +
                ", dislikes = '" + this.getDislikes() + '\'' +
                ", review = '" + reviews + '\'' + "}";
    }

}
