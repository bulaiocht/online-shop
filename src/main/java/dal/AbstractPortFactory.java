package dal;

import dal.port.JudgePort;
import dal.port.PlayerPort;

public abstract class AbstractPortFactory {

    public abstract JudgePort getJudgePort();
    public abstract PlayerPort getPlayerPort();

}
