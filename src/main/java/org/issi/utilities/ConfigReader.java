package org.issi.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class is useful to read properties file
 */
public class ConfigReader {
    /**
     * Here we are creating properties reference ,which is imported from java.util
     */
    private Properties prop;

    /**
     * This method is used to load the properties from config.properties file
     * @return properties
     */
    public Properties initProperties(){
        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
