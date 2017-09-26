package steam.local;

import framework.PropertiesManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LocalManager {
    private static Properties propsLang;

    public static String getLocalName(String name){
        return propsLang.getProperty(name);
    }


    private static String pathToLanguageProperties = "src/test/resources/%s.properties";

    static{
        propsLang = new Properties();
        try {
            propsLang.load(new FileInputStream(new File(String.format(pathToLanguageProperties, PropertiesManager.getLanguage())).getAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
