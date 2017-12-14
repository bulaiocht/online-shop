package dal;

import dal.adapter.JudgePostgresqlAdapter;
import dal.adapter.PlayerPostgresqlAdapter;
import dal.connect.PostgresConnectionSupplier;
import dal.port.JudgePort;
import dal.port.PlayerPort;

public class PostgresqlAdapterFactory extends AbstractPortFactory {

    @Override
    public JudgePort getJudgePort() {
        return new JudgePostgresqlAdapter(new PostgresConnectionSupplier());
    }

    @Override
    public PlayerPort getPlayerPort() {
        return new PlayerPostgresqlAdapter(new PostgresConnectionSupplier());
    }

}
