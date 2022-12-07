package recipe.foodbar.id_generator.jug;

import org.bson.types.ObjectId;
import recipe.foodbar.usecase.user.port.IdGenerator;

public class JugIdGenerator implements IdGenerator {

    @Override
    public String generate() {
        return new ObjectId().toHexString();
    }
}