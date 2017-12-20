package dal;

public class PortFactory {

    public enum DBType{

        MYSQL(new MySQLAdapterFactory()),
        POSTGRES(new PostgresqlAdapterFactory());

        private final AbstractPortFactory factory;

        DBType(AbstractPortFactory factory) {
            this.factory = factory;
        }
    }

    public static AbstractPortFactory getMySQLPortFactory(DBType type){
        return type.factory;
    }
}
