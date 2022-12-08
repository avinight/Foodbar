package recipe.foodbar.repository.simpleDB;

import recipe.foodbar.entities.Cuisine.Cuisine;
import recipe.foodbar.usecase.cuisine.port.CuisineRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryCuisineRepository implements CuisineRepository {

    private final Map<String, Cuisine> inMemoryDb = new HashMap<>();

    @Override
    public Cuisine create(final Cuisine cuisine) {
        inMemoryDb.put(cuisine.getId(), cuisine);
        return cuisine;
    }

    @Override
    public Optional<Cuisine> findById(final String id) {
        return Optional.ofNullable(inMemoryDb.get(id));
    }
}
