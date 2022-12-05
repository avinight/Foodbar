package recipe.foodbar.controller.recipe;

import recipe.foodbar.entities.Recipe;
import recipe.foodbar.entities.User;
import recipe.foodbar.usecase.recipe.exception.RecipeValidationException;
import recipe.foodbar.usecase.recipe.port.RecipeRepository;
import recipe.foodbar.usecase.recipe.validator.RecipeValidator;
import recipe.foodbar.usecase.user.port.IdGenerator;

public class VoteRecipe {

    private final RecipeRepository repository;
    private final IdGenerator idGenerator;

    public VoteRecipe(final RecipeRepository repository, final IdGenerator idGenerator) {
        this.repository = repository;
        this.idGenerator = idGenerator;
    }

    public void upvote(final Recipe recipe, final User voter) throws RecipeValidationException {
        RecipeValidator.validateCreateRecipe(recipe);
        recipe.like(voter.getId());
        repository.update(recipe);
    }

    public void downvote(final Recipe recipe, final User voter) throws RecipeValidationException {
        RecipeValidator.validateCreateRecipe(recipe);
        recipe.dislike(voter.getId());
        repository.update(recipe);
    }

}
