package utility;

import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfigProperties {
    static Properties properties = new Properties();

    public static String getPropertyValueByKey(String key) throws FileNotFoundException {
        //(1)Load data from Config.properties file

        String filePath = System.getProperty("user.dir") + "/src/main/resources/config.properties";
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(filePath);
            properties.load(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //(2) Read data

        String value = properties.get(key).toString();

        if (StringUtils.isEmpty(value)) {
            try {
                throw new Exception("Value is not specified for key: " + key + "in config.properties.");

            } catch (Exception e) {
            }

        }
        return value;
    }

}