package dal.connect;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class PostgresConnectionSupplier implements ConnectionSupplier {

     private DataSource postgresDataSource;

     {
         try {
             Context ctx = new InitialContext();
             postgresDataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/rds");
         } catch (NamingException e) {
             e.printStackTrace();
         }
     }

    @Override
    public Connection getConnection() throws SQLException{
        return postgresDataSource.getConnection();
    }
}
