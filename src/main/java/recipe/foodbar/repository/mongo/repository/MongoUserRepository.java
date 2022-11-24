package recipe.foodbar.repository.mongo.repository;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;
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

    @Override
    public Optional<User> findByUsername(String username) {
        Optional<UserModel> um = Optional.ofNullable(collection.find(eq("username", username))
                .first());
        return um.map(UserMapper::toEntity);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        Optional<UserModel> um = Optional.ofNullable(collection.find(eq("email", email))
                .first());
        return um.map(UserMapper::toEntity);
    }

    @Override
    public ArrayList<User> findAllUsers() {
        List<UserModel> userModelList = collection.find().into(new ArrayList<UserModel>());
        List<User> userList = userModelList.stream().map(UserMapper::toEntity).collect(Collectors.toList());
        return (ArrayList<User>) userList;
    }

    @Override
    public boolean existsByUsername(String username) {
        return false;
    }
}
