package recipe.foodbar.repository.mongo.repository;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;
import org.bson.conversions.Bson;
import recipe.foodbar.entities.User;
import recipe.foodbar.repository.mongo.MongoDB;
import recipe.foodbar.repository.mongo.mapper.UserMapper;
import recipe.foodbar.repository.mongo.model.UserModel;
import recipe.foodbar.usecase.user.port.UserRepositoryInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.mongodb.client.model.Filters.eq;

public class MongoUserRepository implements UserRepositoryInterface {

    MongoDatabase db = MongoDB.getReference();
    MongoCollection<UserModel> collection = db.getCollection("User", UserModel.class);

    @Override
    public void create(User user) {
        try {
            UserModel um = UserMapper.toUserModel(user);
            InsertOneResult result = collection.insertOne(um);
            System.out.println("Success! Inserted document id: " + result.getInsertedId());
        } catch (MongoException me) {
            System.err.println("Unable to insert user due to an error: " + me);
        }
    }

    /**
     * Abstract method for finding a user by their username in the repository
     *
     * @param id the String representation of the id
     * @return to be implemented by classes which implement the interface.
     */
    @Override
    public Optional<User> findById(String id) {
        return Optional.empty();
    }

//    @Override
//    public Optional<User> findByUsername(String username) {
//        Bson query = eq("username", username);
//        Optional<UserModel> um = Optional.ofNullable(collection.find(query)
//                .first());
//        return um.map(UserMapper::toEntity);
//    }

    @Override
    public Optional<User> findByEmail(String email) {
        Bson query = eq("email", email);
        Optional<UserModel> um = Optional.ofNullable(collection.find(query)
                .first());
        return um.map(UserMapper::toEntity);
    }

    @Override
    public ArrayList<User> findAllUsers() {
        List<UserModel> userModelList = collection.find().into(new ArrayList<>());
        List<User> userList = userModelList.stream().map(UserMapper::toEntity).collect(Collectors.toList());
        return (ArrayList<User>) userList;
    }

    @Override
    public boolean existsByUsername(String username) {
        return collection.countDocuments(eq("username", username)) > 0;
    }

    /**
     * Abstract method for getting password
     *
     * @param username the String representation of the username
     * @return to be implemented
     */
    @Override
    public String getPassword(String username) {
        return null;
    }

    @Override
    public Optional<User> getByUsername(String username) {
        return Optional.empty();
    }
}
