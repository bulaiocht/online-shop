package dal.connect;

import config.MySQLDBConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class MySQLConnectionSupplier implements ConnectionSupplier {

    private static final Logger logger = LogManager.getLogger(MySQLConnectionSupplier.class);

    private DataSource mySQLDataSource;
    {
        try {
            Context ctx = new InitialContext();
            mySQLDataSource = (DataSource) ctx.lookup(MySQLDBConfig.getDataSourcePath());
        } catch (NamingException e) {
            logger.error("Naming exception!", e);
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        return mySQLDataSource.getConnection();
    }

}
