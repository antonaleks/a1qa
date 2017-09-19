package framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



public class PropertiesData {
    private static String url;
    private static String browser;


    private static int timeDelayImp;
    private static int timeDelayExp;

    private static String pathToProperties = "src/test/resources/config.properties";

    public static int getTimeDelayImp() {
        return timeDelayImp;
    }


    public static int getTimeDelayExp() {
        return timeDelayExp;
    }

    public static String getUrl() {
        return url;
    }

    public static String getBrowser() {
        return browser;
    }

    static {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream(new File(pathToProperties).getAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        url = props.getProperty("url");
        browser = props.getProperty("browser");
        timeDelayImp = Integer.valueOf(props.getProperty("timeDelayImp"));
        timeDelayExp = Integer.valueOf(props.getProperty("timeDelayExp"));
    }

}
