package recipe.foodbar.repository;
import recipe.foodbar.entities.User;
import recipe.foodbar.usecase.user_login.port.LoginRepositoryInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class InMemoryCookieRepository implements LoginRepositoryInterface {

    private final Map<String, User> inMemoryDb = new HashMap<>();

    @Override
    public void add(final User user, final String cookie){
        inMemoryDb.put(cookie, user);
    }

    @Override
    public Optional<User> findByCookie(final String cookie){
        return Optional.ofNullable(inMemoryDb.get(cookie));
    }

    @Override
    public ArrayList<User> findAllActive(){
        return new ArrayList<>(inMemoryDb.values());
    }


}
