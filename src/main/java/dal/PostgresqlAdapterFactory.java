package dal;

import dal.adapter.UserPostgresqlAdapter;
import dal.connect.PostgresConnectionSupplier;
import dal.port.UserPort;

public class PostgresqlAdapterFactory extends AbstractPortFactory {
    @Override
    public UserPort getUserPort() {
        return new UserPostgresqlAdapter(new PostgresConnectionSupplier());
    }
}