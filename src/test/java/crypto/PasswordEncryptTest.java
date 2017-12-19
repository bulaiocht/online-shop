package crypto;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Kocherha Vitalii on 19.12.2017.
 */
public class PasswordEncryptTest {

    private static final Logger logger = LogManager.getLogger(PasswordEncryptTest.class);
    private static final String NULL_PASS = null;
    private static final String okPass = "password1string";

    @Test
    public void encryptNullStringWithException() {
        try {
            logger.info("Going to catch IllegalArgumentException");
            PasswordEncrypt.encryptToHexString(NULL_PASS);
        } catch (IllegalArgumentException e) {
            logger.info("Exception caught", e);
        }
    }

    @Test
    public void encryptWithoutException(){
        String outputOne = PasswordEncrypt.encryptToHexString(okPass);
        String outputTwo = PasswordEncrypt.encryptToHexString(okPass);
        logger.info(String.format("Pass: %s . Encrypted hexadecimal: %s ", okPass, outputOne));
        logger.info(String.format("Pass: %s . Encrypted hexadecimal: %s ", okPass, outputTwo));
        assertNotNull(outputOne);
        assertNotNull(outputTwo);
        assertEquals(outputTwo, outputOne);
    }
}