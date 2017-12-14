package dal.connect;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionSupplier {

    Connection getConnection () throws SQLException;

}
