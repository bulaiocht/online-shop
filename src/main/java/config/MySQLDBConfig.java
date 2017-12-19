package config;

import java.util.ResourceBundle;

public class MySQLDBConfig {
    private static final String ENV_PATH_KEY="ENV_PATH";
    private static final String DS_NAME_KEY="DATASOURCE_NAME";
    private static final String BUNDLE_NAME="db_mysql";

    public static String getDataSourcePath(){
        ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME);
        return bundle.getString(ENV_PATH_KEY) + bundle.getString(DS_NAME_KEY);
    }
}
