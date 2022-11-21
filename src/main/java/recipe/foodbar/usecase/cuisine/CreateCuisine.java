package recipe.foodbar.usecase.cuisine;

import recipe.foodbar.entities.Cuisine;
import recipe.foodbar.usecase.cuisine.exception.CuisineAlreadyExistsException;
import recipe.foodbar.usecase.cuisine.port.CuisineRepository;
import recipe.foodbar.usecase.cuisine.validator.CuisineValidator;
import recipe.foodbar.usecase.user_example.port.IdGenerator;

public class CreateCuisine {
    private final CuisineRepository repository;
    private final IdGenerator idGenerator;

    public CreateCuisine(final CuisineRepository repository, final IdGenerator idGenerator) {
        this.repository = repository;
        this.idGenerator = idGenerator;
    }

    public Cuisine create(final Cuisine cuisine) {
        CuisineValidator.validateCuisineRecipe(cuisine);
        if (repository.findById(cuisine.getId()).isPresent()) {
            throw new CuisineAlreadyExistsException("Cuisine already exists");
        }
        Cuisine cuisineToSave = Cuisine.builder()
                .name(cuisine.getName())
                .id(cuisine.getId())
                .recipes()
                .build();

        return repository.create(cuisineToSave);
    }
}
