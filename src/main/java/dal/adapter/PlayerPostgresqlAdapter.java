package dal.adapter;

import dal.connect.ConnectionSupplier;
import dal.port.PlayerPort;
import domain.Player;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlayerPostgresqlAdapter implements PlayerPort {

    private static final Logger logger = Logger.getLogger(PlayerPostgresqlAdapter.class);


    private ConnectionSupplier connectionSupplier;

    private static final String SELECT_ALL = "SELECT * FROM player";

    public PlayerPostgresqlAdapter(ConnectionSupplier connectionSupplier) {
        this.connectionSupplier = connectionSupplier;
    }

    @Override
    public List<Player> getAllPlayers() {
        List<Player> players = new ArrayList<>();
        try(Connection conn = connectionSupplier.getConnection()){
            if (conn!=null){
                logger.info("Connection obtained");
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(SELECT_ALL);
                while (resultSet.next()){
                    Player player = new Player(resultSet.getInt("player_id"),
                            resultSet.getString("username"));
                    players.add(player);
                }

            } else throw new SQLException();
        } catch (SQLException e) {
            logger.fatal("Failed to get connection!", e.getCause());
        }
        return players;

    }
}
