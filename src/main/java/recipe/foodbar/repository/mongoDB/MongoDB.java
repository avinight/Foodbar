package recipe.foodbar.repository.mongoDB;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
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
    /**
     * Mongo DB class responsible for creating MongoDB instance.
     * Change the uri to mongoDB instance, if not using the default
     **/

    public static MongoDatabase getMongoDB() {
        if (System.getProperty("MONGO_DB_URI") != null) {
            final String uri = System.getProperty("MONGO_DB_URI");
        } else {
            final String uri = "mongodb://localhost:27017";
        }
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
        MongoClient mongoClient = MongoClients.create(
                MongoClientSettings.builder()
                        .applyConnectionString(new ConnectionString(uri))
                        .codecRegistry(pojoCodecRegistry)
                        .build());
        MongoDatabase db = mongoClient.getDatabase("FoodBar");
        Bson command = new BsonDocument("ping", new BsonInt64(1));
        Document commandResult = mongoClient.getDatabase("FoodBar").runCommand(command);
        System.out.println("MongoDB: Connected successfully to server." + commandResult);
        return db;
    }
}