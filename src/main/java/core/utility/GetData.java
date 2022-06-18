package core.utility;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.ResourceBundle;

public class GetData {

    public  String property(String key)  {
        String property = null;
        InputStream stream = null;

        try {
            Properties prop = new Properties();
            String propFileName = "resources/conf.properties";
            prop.load(new FileReader(propFileName));

            property = prop.getProperty(key);
           // System.out.println(prop.get(key));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return property;
    }

}
