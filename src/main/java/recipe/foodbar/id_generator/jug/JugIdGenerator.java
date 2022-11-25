package recipe.foodbar.id_generator.jug;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.NoArgGenerator;
import recipe.foodbar.usecase.user.port.IdGenerator;

public class JugIdGenerator implements IdGenerator {

    private static NoArgGenerator generator() {
        return Generators.timeBasedGenerator(EthernetAddress.fromInterface());
    }

    @Override
    public String generate() {
        return generator().generate().toString().replaceAll("-", "");
    }
}