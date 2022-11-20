package recipe.foodbar.usecase.cuisine.port;

import recipe.foodbar.entities.Cuisine;

import java.util.Optional;

public interface CuisineRepository {
    Cuisine create(Cuisine cuisine);

    Optional<Cuisine> findById(final String id);


}
