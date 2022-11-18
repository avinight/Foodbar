package recipe.foodbar.id_generator.jug;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.NoArgGenerator;
import recipe.foodbar.usecase.user_example.port.IdGenerator;

public class JugIdGenerator implements IdGenerator {

    @Override
    public String generate() {
        return generator().generate().toString().replaceAll("-", "");
    }

    private static NoArgGenerator generator() {
        return Generators.timeBasedGenerator(EthernetAddress.fromInterface());
    }
}