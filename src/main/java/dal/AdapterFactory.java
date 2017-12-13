package dal;

import dal.adapter.JudgeAdapter;
import dal.adapter.PlayerAdapter;
import dal.port.JudgePort;
import dal.port.PlayerPort;

/**
 * Created by Kocherha Vitalii on 13.12.2017.
 */
public class AdapterFactory extends AbstractPortFactory {

    @Override
    JudgePort getJudgePort() {
        return new JudgeAdapter();
    }

    @Override
    PlayerPort getPlayerPort() {
        return new PlayerAdapter();
    }

}
