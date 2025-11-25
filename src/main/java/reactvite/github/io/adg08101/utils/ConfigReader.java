package reactvite.github.io.adg08101.utils;

import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
        try {
            properties = new Properties();
            properties.load(
                    ConfigReader.class
                            .getClassLoader()
                            .getResourceAsStream("config.properties")
            );
        } catch (Exception e) {
            throw new RuntimeException("Unable to load config.properties file!", e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
