package recipe.foodbar.usecase.recipe.manager;

import recipe.foodbar.entities.Recipe.Recipe;
import recipe.foodbar.entities.User;
import recipe.foodbar.usecase.recipe.port.RecipeRepository;
import recipe.foodbar.usecase.recipe.validator.RecipeValidator;
import recipe.foodbar.usecase.user.port.IdGenerator;
import recipe.foodbar.entities.*;

import java.util.ArrayList;
import java.util.Date;

public class CreateRecipeInteractor implements CreateRecipeInputBoundary{
    private final RecipeRepository repository;
    private final IdGenerator idGenerator;
    private final CreateRecipeOutputBoundary presenter;

    public CreateRecipeInteractor(RecipeRepository repository, IdGenerator idGenerator, CreateRecipeOutputBoundary presenter) {
        this.repository = repository;
        this.idGenerator = idGenerator;
//        this.presenter = presenter1;
        this.presenter = presenter;
    }

//    public Recipe create(final Recipe recipe) throws RecipeAlreadyExistsException {
//        RecipeValidator.validateCreateRecipe(recipe);
//        if (repository.findById(recipe.getId()).isPresent()) {
//            throw new RecipeAlreadyExistsException("Recipe already exists");
//        }
//        Recipe recipeToSave = Recipe.builder()
//                .id(idGenerator.generate())
//                .title(recipe.getTitle())
//                .author(recipe.getAuthor())
//                .instructions(recipe.getInstructions())
//                .cuisine(recipe.getCuisine())
//                .portionSize(recipe.getPortionSize())
//                .dietaryRestrictions(recipe.getDietaryRestrictions())
//                .dateCreated(recipe.getDateCreated())
//                .createRecipe();
//
//
//        return repository.create(recipeToSave);
//    }

    @Override
    public String create(RecipeInputData input) {
        String idNum = idGenerator.generate();
        String rTitle = input.getTitle();
        User rAuthor = input.getAuthor(); // class wasn't imported
        String[] rInstructions = input.getInstructions();
        Cuisine rCui = input.getCuisine(); // class wasn't imported
        float rPortion = input.getPortionSize();
        String[] rGI = input.getInstructions();
        String[] rDR = input.getDietaryRestrictions();
        ArrayList<Ingredient> rIng = input.getIngredients();
        Date rDate = input.getDateCreated();
        // TODO: the bottom assignment statements assume that at the time of recipe creation, the likes, dislikes are
        //  both zero and the list of reviews is empty
        ArrayList<String> rLikers = input.getLikers();
        ArrayList<String> rDislikers = input.getDislikers();
        ArrayList<Review> rReviews = input.getReviews();

        Recipe recipeToSave = Recipe.builder()
                .id(idNum)
                .title(rTitle)
                .author(rAuthor)
                .instructions(rInstructions)
                .cuisine(rCui)
                .portionSize(rPortion)
                .ingredients(rIng)
                .dietaryRestrictions(rDR)
                .dateCreated(rDate)
                .likers(rLikers)
                .dislikers(rDislikers)
                .reviews(rReviews)
                .createRecipe();


//        Recipe recipeToSave = Recipe.builder()
//                .id(idGenerator.generate())
//                .title(input.getTitle())
//                .author(input.getAuthor())
//                .instructions(input.getInstructions())
//                .cuisine(input.getCuisine())
//                .portionSize(input.getPortionSize())
//                .dietaryRestrictions(input.getDietaryRestrictions())
//                .dateCreated(input.getDateCreated())
//                .createRecipe();

        RecipeValidator.validateCreateRecipe(recipeToSave);

        // TODO: also need to ensure that the recipe being saved to the recipe repository is valid since other use
        //  cases assume that if the recipe is not in the repo then they are invalid (the repo should not have any
        //  invalid recipes)

        // TODO: Assuming the validator above throws the appropriate exception and doesn't allow the code below to
        //  execute, we can present a message of the recipe being successfully created through the presenter. I think
        //  that the exceptions thrown by the validator above in case of an invalid entry should also
        //  be passed out through the presenter attribute of this interactor since it's job is communicating
        //  with the UI. Confirm with Roney!!
        repository.create(recipeToSave);

        // need to return the ID of the recipe object that was created
        String recipeID = recipeToSave.getId();
        return presenter.getID(recipeID);
    }
}
