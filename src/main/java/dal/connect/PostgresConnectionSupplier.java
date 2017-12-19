package dal.connect;

import config.PostgresDBConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class PostgresConnectionSupplier implements ConnectionSupplier {

    private static final Logger logger = LogManager.getLogger(PostgresConnectionSupplier.class);

    private DataSource postgresDataSource;

    {
        try {
            Context ctx = new InitialContext();
            postgresDataSource = (DataSource) ctx.lookup(PostgresDBConfig.getDataSourcePath());
        } catch (NamingException e) {
            logger.error("Naming exception while creating connection supplier!", e);
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        return postgresDataSource.getConnection();
    }
}
