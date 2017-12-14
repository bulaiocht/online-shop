package dal.adapter;

import dal.connect.ConnectionSupplier;
import dal.port.JudgePort;
import domain.Judge;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JudgePostgresqlAdapter implements JudgePort {

    private static final Logger logger = Logger.getLogger(JudgePostgresqlAdapter.class);

    private ConnectionSupplier connectionSupplier;

    private static final String SELECT_ALL = "SELECT * FROM judge";

    public JudgePostgresqlAdapter(ConnectionSupplier connectionSupplier) {
        this.connectionSupplier = connectionSupplier;
    }

    @Override
    public List<Judge> getAllJudges() {
        List<Judge> judges = new ArrayList<>();
        try(Connection conn = connectionSupplier.getConnection()){
            if (conn!=null){
                logger.info("Connection obtained");
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(SELECT_ALL);
                while (resultSet.next()){
                    Judge judge = new Judge(resultSet.getInt("judge_id"),
                            resultSet.getString("username"));
                    judges.add(judge);
                }
            }
        } catch (SQLException e) {
            logger.fatal("Failed to get connection!", e.getCause());
        }
        return judges;
    }
}
