package config;

import java.util.Optional;
import java.util.ResourceBundle;

public class MySQLDBConfig {

    private static final String ENV_PATH_KEY="ENV_PATH";
    private static final String DS_NAME_KEY="DATASOURCE_NAME";
    private static final String DEF_BUNDLE_NAME="db_mysql";

    public static String getDataSourcePath(String bundleName){
        String bundlePath = Optional.ofNullable(bundleName).orElse(DEF_BUNDLE_NAME);
        ResourceBundle bundle = ResourceBundle.getBundle(bundlePath);
        return bundle.getString(ENV_PATH_KEY) + bundle.getString(DS_NAME_KEY);
    }

    public static String getDataSourcePath(){
        return getDataSourcePath(null);
    }
}
