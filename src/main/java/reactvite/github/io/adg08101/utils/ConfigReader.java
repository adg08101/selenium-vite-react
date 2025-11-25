package reactvite.github.io.adg08101.utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
        try {
            FileInputStream file = new FileInputStream("./config.properties");
            properties = new Properties();
            properties.load(file);
        } catch (IOException e) {
            throw new RuntimeException("Unable to load config.properties file!");
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}