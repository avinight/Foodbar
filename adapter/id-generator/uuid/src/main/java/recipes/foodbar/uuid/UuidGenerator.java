package recipes.foodbar.uuid;

import recipes.foodbar.usecase.user.port.IdGenerator;

import java.util.UUID;

public class UuidGenerator implements IdGenerator {

    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}