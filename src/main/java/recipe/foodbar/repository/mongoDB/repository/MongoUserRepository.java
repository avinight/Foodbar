package recipe.foodbar.repository.mongoDB.repository;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.ReplaceOptions;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.bson.conversions.Bson;
import recipe.foodbar.entities.User;
import recipe.foodbar.repository.mongoDB.mapper.RecipeMapper;
import recipe.foodbar.repository.mongoDB.mapper.UserMapper;
import recipe.foodbar.repository.mongoDB.model.RecipeModel;
import recipe.foodbar.repository.mongoDB.model.UserModel;
import recipe.foodbar.usecase.user.port.UserRepositoryInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.mongodb.client.model.Filters.eq;

public class MongoUserRepository implements UserRepositoryInterface {

    MongoCollection<UserModel> collection;

    public MongoUserRepository(MongoDatabase db) {
        Bson command = new BsonDocument("ping", new BsonInt64(1));
        Document commandResult = db.runCommand(command);
        System.out.println(this.getClass().getSimpleName() + ": Connected successfully to server." + commandResult);
        collection = db.getCollection("Users", UserModel.class);
    }

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
        Bson query = eq("username", username);
        Optional<UserModel> um = Optional.ofNullable(collection.find(query)
                .first());
        return um.map(UserMapper::toEntity);
    }

    @Override
    public Optional<User> findById(String id) {
        Bson query = eq("_id", id);
//        Bson query = eq("_id", new ObjectId(id));
        Optional<UserModel> rm = Optional.ofNullable(collection.find(query).first());
        return rm.map(UserMapper::toEntity);
    }

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

    /**
     * Update the user object after one of its attributes has been answered
     *
     * @param user The user object that needs to be udpated
     * @return the user object that was updated
     */
    @Override
    public User update(User user) {
        UserModel rm = UserMapper.toUserModel(user);
        Bson query = eq("_id", user.getId());
        ReplaceOptions opts = new ReplaceOptions().upsert(true);
        UpdateResult result = collection.replaceOne(query, rm, opts);
//        Todo: Remove console println, do we need to return Recipe?
        System.out.println(result);
        return user;
    }

    @Override
    public boolean existsByUsername(String username) {
        return collection.countDocuments(eq("username", username)) > 0;
    }
}