package recipe.foodbar.repository.h2DB;

import org.jdbi.v3.core.Jdbi;
import recipe.foodbar.entities.UserExample;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        Jdbi jdbi = Jdbi.create("jdbc:h2:file:" + System.getProperty("user.dir") +
                        "/src/main/java/recipe.foodbar/repository/h2DB/database");

        //Jdbi jdbi = Jdbi.create("jdbc:h2:file:src/main/java/recipe.foodbar/repository/h2DB/databse");
       // Jdbi jdbi = Jdbi.create("jdbc:h2:mem:test"); // (H2 in-memory database)

//        List<UserExample> users = jdbi.withHandle(handle -> {
//            handle.execute("CREATE TABLE \"user\" (id INTEGER PRIMARY KEY, \"name\" VARCHAR)");
        List<UserExample> users = jdbi.withHandle(handle -> {
            handle.execute("CREATE TABLE \"user\" (id INTEGER PRIMARY KEY, \"name\" VARCHAR)");

            // Inline positional parameters
//        handle.execute("INSERT INTO \"user\" (id, \"name\") VALUES (?, ?)", 0, "Alice");
//
//        // Positional parameters
//        handle.createUpdate("INSERT INTO \"user\" (id, \"name\") VALUES (?, ?)")
//                .bind(0, 1) // 0-based parameter indexes
//                .bind(1, "Bob")
//                .execute();

        // Named parameters
        handle.createUpdate("INSERT INTO \"user\" (id, \"name\") VALUES (:id, :name)")
                .bind("id", 2)
                .bind("name", "Clarice")
                .execute();

//            // Named parameters from bean properties
//            handle.createUpdate("INSERT INTO \"user\" (id, \"name\") VALUES (:id, :name)")
//                    .bindBean(new UserExample("username", "username@email.com", "password",
//                            "firstname", "lastname"))
//                    .execute();
//
//            // Easy mapping to any type
//            return handle.createQuery("SELECT * FROM \"user\" ORDER BY \"name\"")
//                    .mapToBean(UserExample.class)
//                    .list();

            return null;
        });
    }


}
