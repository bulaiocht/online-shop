package config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.*;

public class MySQLDBConfigTest {

    private static final Logger logger = LogManager.getLogger(MySQLDBConfigTest.class);

    private static final String TEST_BUNDLE_NAME ="test";
    private static final String TEST_DS_PATH = "FOO/BAR";
    private static final String DEF_DS_PATH = "REAL_FOO/REAL_BAR";

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