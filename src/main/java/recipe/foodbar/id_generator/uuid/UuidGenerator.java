package recipe.foodbar.id_generator.uuid;

import recipe.foodbar.usecase.user.port.IdGenerator;

import java.util.UUID;

public class UuidGenerator implements IdGenerator {

    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}