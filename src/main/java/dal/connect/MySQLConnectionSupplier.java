package dal.connect;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by Kocherha Vitalii on 18.12.2017.
 */
public class MySQLConnectionSupplier implements ConnectionSupplier {
    private DataSource mySQLDataSource;

    private final static String ENV = "java:comp/env/";
    private final static String BUNDLE_NAME = "db_mysql";
    private String datasourceName = null;

    {
        try {
            Context ctx = new InitialContext();
            ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME);
            if (bundle.containsKey("datasourceName")){
                datasourceName = bundle.getString("datasourceName");
            }

            mySQLDataSource = (DataSource) ctx.lookup(ENV + datasourceName);

        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        return mySQLDataSource.getConnection();
    }

}
