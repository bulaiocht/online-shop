package crypto;

import org.apache.commons.codec.digest.DigestUtils;
import java.util.Optional;

/**
 * Created by Kocherha Vitalii on 19.12.2017.
 */
public class PasswordEncrypt {

    public static String encryptToHexString(String pass){
        String notNullPass = Optional.ofNullable(pass)
                .orElseThrow(IllegalArgumentException::new);
        return DigestUtils.sha256Hex(notNullPass);
    }

    public static byte[] encryptToByteArray(String pass){
        String notNullPass = Optional.ofNullable(pass)
                .orElseThrow(IllegalArgumentException::new);
        return DigestUtils.sha256(notNullPass);
    }
}
