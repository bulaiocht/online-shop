package config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Kocherha Vitalii on 19.12.2017.
 */
public class MySQLDBConfigTest {

    private static final Logger logger = LogManager.getLogger(MySQLDBConfigTest.class);

    private static final String TEST_BUNDLE_NAME ="test";
    private static final String TEST_DS_PATH = "FOO/BAR";
    private static final String DEF_DS_PATH = "FOOO/BAAAR";

    @Test
    public void getDataSourceFromPropertyPathTest() {
        String actualOne = MySQLDBConfig.getDataSourcePath(TEST_BUNDLE_NAME);
        String actualTwo = MySQLDBConfig.getDataSourcePath();
        logger.info("Test path: " + actualOne);
        logger.info("Default pat: "+ actualTwo);
        assertEquals(actualOne, TEST_DS_PATH);
        assertEquals(actualTwo, DEF_DS_PATH);
    }
}