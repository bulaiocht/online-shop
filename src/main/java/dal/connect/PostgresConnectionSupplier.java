package dal.connect;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PostgresConnectionSupplier implements ConnectionSupplier {

     private DataSource postgresDataSource;

     private final static String ENV = "java:comp/env/";
     private final static String BUNDLE_NAME = "db_postgres";
     private String datasourceName = null;

     {
         try {
             Context ctx = new InitialContext();
             ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME);
             if (bundle.containsKey("datasourceName")){
                 datasourceName = bundle.getString("datasourceName");
             }
             postgresDataSource = (DataSource) ctx.lookup(ENV + datasourceName);

         } catch (NamingException e) {
             e.printStackTrace();
         }
     }

    @Override
    public Connection getConnection() throws SQLException{
        return postgresDataSource.getConnection();
    }
}
