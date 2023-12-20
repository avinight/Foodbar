package foodbar.controller.recipe;

import foodbar.entities.Recipe;
import foodbar.entities.User;
import foodbar.usecase.recipe.exception.RecipeValidationException;
import foodbar.usecase.recipe.port.RecipeRepository;
import foodbar.usecase.recipe.validator.RecipeValidator;
import foodbar.usecase.commonport.IdGenerator;

public class VoteRecipe {

    private final RecipeRepository repository;
    private final IdGenerator idGenerator;

    /**
     * Controller for liking/disliking on recipes
     * @param repository the repository where the recipes reside
     * @param idGenerator the generator for recipe id
     */
    public VoteRecipe(final RecipeRepository repository, final IdGenerator idGenerator) {
        this.repository = repository;
        this.idGenerator = idGenerator;
    }

    /**
     * Adds the voter to the recipe's likers obeying the rules in recipe.like()
     * @param recipe recipe to be liked
     * @param voter voter to like the recipe
     * @throws RecipeValidationException ensure that recipe is valid
     */
    public void upvote(final Recipe recipe, final User voter) throws RecipeValidationException {
        RecipeValidator.validateCreateRecipe(recipe);
        recipe.like(voter.getId());
        repository.update(recipe);
    }

    /**
     * Adds the voter to the recipe's dislikers obeying the rules in recipe.like()
     * @param recipe recipe to be liked
     * @param voter voter to like the recipe
     * @throws RecipeValidationException ensure that recipe is valid
     */
    public void downvote(final Recipe recipe, final User voter) throws RecipeValidationException {
        RecipeValidator.validateCreateRecipe(recipe);
        recipe.dislike(voter.getId());
        repository.update(recipe);
    }

}
