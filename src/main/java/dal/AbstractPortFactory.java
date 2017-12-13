package dal;

import dal.port.JudgePort;
import dal.port.PlayerPort;

/**
 * Created by Kocherha Vitalii on 13.12.2017.
 */
public abstract class AbstractPortFactory {
    abstract JudgePort getJudgePort();
    abstract PlayerPort getPlayerPort();
}
