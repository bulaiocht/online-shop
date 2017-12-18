package dal;

import dal.adapter.UserMySQLAdapter;
import dal.adapter.UserPostgresqlAdapter;
import dal.connect.MySQLConnectionSupplier;
import dal.connect.PostgresConnectionSupplier;
import dal.port.UserPort;

public class MySQLAdapterFactory extends AbstractPortFactory {

    @Override
    public UserPort getUserPort() {
        return new UserMySQLAdapter(new MySQLConnectionSupplier());
    }

}
