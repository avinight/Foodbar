package recipe.foodbar.repository.mongoDB;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import lombok.NoArgsConstructor;
import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@NoArgsConstructor
public class MongoDB {

    private static final String uri = "mongodb://localhost:27017";

    private static MongoClient mongoClient;

    public static void main(String[] args) {
//        db = getReference();
//        final IdGenerator idGenerator = new JugIdGenerator();
////            UserModel um = new UserModel(new ObjectId(idGenerator.generate()), "roney", "dsfsdf", "dsfsdf", "sdfsdf", "dsfsdf@fsd.com");
//        UserModelTest um = new UserModelTest("roney", "dsfsdf", "dsfsdf", "sdfsdf", "dsfsdf@fsd.com");
////        MongoCollection<UserModelTest> collection = db.getCollection("UserTest", UserModelTest.class);
//        MongoCollection<Document> collection = db.getCollection("movies");
//
//        Bson command = new BsonDocument("ping", new BsonInt64(1));
//        Document commandResult = db.runCommand(command);
//        System.out.println("Connected successfully to server.");

//        Document doc1 = new Document("color", "red").append("qty", 5);
//        InsertOneResult result = collection.insertOne(doc1);
//        System.out.println("Inserted a document with the following id: "
//                + result.getInsertedId().asObjectId().getValue());
//        System.out.println(db);
//        InsertOneResult result = collection.insertOne(um);
//        System.out.println("Success! Inserted document id: " + result.getInsertedId());
//        getReference();
    }

    public static MongoClient getMongoClient() {
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
        MongoClient mongoClient = MongoClients.create(
                MongoClientSettings.builder()
                        .applyConnectionString(new ConnectionString(uri))
                        .codecRegistry(pojoCodecRegistry)
                        .build());
        Bson command = new BsonDocument("ping", new BsonInt64(1));
        Document commandResult = mongoClient.getDatabase("FoodBar").runCommand(command);
        System.out.println("MongoDB: Connected successfully to server." + commandResult);
        return mongoClient;
    }

    public static MongoDatabase getMongoDB() {
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
        MongoClient mongoClient = MongoClients.create(
                MongoClientSettings.builder()
                        .applyConnectionString(new ConnectionString(uri))
                        .codecRegistry(pojoCodecRegistry)
                        .build());
        MongoDatabase db = mongoClient.getDatabase("FoodBar");
        return db;
    }

}