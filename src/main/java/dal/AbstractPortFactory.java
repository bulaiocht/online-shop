package dal;

import dal.port.UserPort;

public abstract class AbstractPortFactory {

    public abstract UserPort getUserPort();

}
