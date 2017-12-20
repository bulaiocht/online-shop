package crypto;

import config.CryptConfig;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Optional;

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

    public static String saltGenerator(){
        String saltLengthConf = CryptConfig.getConfig(CryptConfig.Configs.SALT_LENGTH);
        int saltLength = Integer.parseInt(saltLengthConf);
        return RandomStringUtils.randomAscii(saltLength);
    }
}
