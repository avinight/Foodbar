package foodbar.id_generator.jug;

import org.bson.types.ObjectId;

import foodbar.usecase.commonport.IdGenerator;

public class JugIdGenerator implements IdGenerator {

    @Override
    public String generate() {
        return new ObjectId().toHexString();
    }
}