package recipe.foodbar.repository.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MongoDB {

    private MongoDB() {
    }

    private static final String uri = "mongodb://localhost:27017";

    private static MongoDatabase db;

    public static void main(String[] args) {
        // Replace the uri string with your MongoDB deployment's connection string

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            // Creates a database named recipe
            MongoDatabase db = mongoClient.getDatabase("recipe");

//            Document doc = new Document("playerName", "Ronaldo")
//                    .append("age", 25)
//                    .append("nationality", "Filipino")
//                    .append("JerseyNumber", 23)
//                    .append("position", "Guard");
//            db.getCollection("playerInfo").insertOne(doc);
            System.out.println();
        }
    }

    public static synchronized MongoDatabase getReference() {
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
        if (db == null) {
            try (MongoClient mongoClient = MongoClients.create(uri)) {
                // Creates a database named recipe
                db = mongoClient.getDatabase("recipe");
                return db;
            }
        }
        return db;
    }

}