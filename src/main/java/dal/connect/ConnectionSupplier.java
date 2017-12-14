package dal.connect;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionSupplier {

    Connection getConnection () throws SQLException;

}
