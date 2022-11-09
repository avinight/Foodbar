package recipes.foodbar.encoder;

import org.apache.commons.codec.digest.DigestUtils;
import recipes.foodbar.usecase.user.port.PasswordEncoder;

public class Sha256PasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(final String str) {
        return DigestUtils.sha256Hex(str);
    }
}