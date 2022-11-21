package recipe.foodbar.encoder.sha256;

import org.apache.commons.codec.digest.DigestUtils;
import recipe.foodbar.usecase.user_example.port.PasswordEncoder;

public class Sha256PasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(final String str) {
        return DigestUtils.sha256Hex(str);
    }
}