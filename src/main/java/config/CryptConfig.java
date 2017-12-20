package config;

import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Created by Kocherha Vitalii on 20.12.2017.
 */
public class CryptConfig {

    private static final String BUNDLE_NAME="crypt";
    private static final ResourceBundle BUNDLE;


    static {
        BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
    }

    public enum Configs{
        SALT_LENGTH
    }

    public static String getConfig(Configs configs){
        Configs key = Optional.ofNullable(configs).orElseThrow(IllegalArgumentException::new);
        return BUNDLE.getString(key.name());
    }
}

