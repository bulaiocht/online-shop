package crypto;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.*;


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

    @Test
    public void encryptToByteArray() {
    }

    @Test
    public void saltGenerator() {
        String saltOne = PasswordEncrypt.saltGenerator();
        String saltTwo = PasswordEncrypt.saltGenerator();
        logger.info("Salty string: " + saltOne + " length: " + saltOne.length());
        logger.info("Salty string: " + saltTwo + " length: " + saltTwo.length());
        assertTrue(saltOne.length()==20);
        assertTrue(saltTwo.length()==20);
        assertNotEquals(saltOne, saltTwo);
    }
}