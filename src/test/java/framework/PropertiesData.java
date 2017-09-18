package framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



public class PropertiesData {
    private static String URL;
    private static String LOGIN;
    private static String PASSWORD;
    private static String BROWSER;
    private static String PATH_TO_FIREFOX_DRIVER;
    private static String PATH_TO_CHROME_DRIVER;
    private static String PATH_TO_CSV_FILE;


    private static int TIME_DELAY_IMP;
    private static int TIME_DELAY_EXP;

    private static final String PATH_TO_PROPERTIES = "src/test/resources/config.properties";

    public static int getTimeDelayImp() {
        return TIME_DELAY_IMP;
    }


    public static int getTimeDelayExp() {
        return TIME_DELAY_EXP;
    }


    public static String getPathToCsvFile() {
        return PATH_TO_CSV_FILE;
    }

    public static String getPathToChromeDriver() {
        return PATH_TO_CHROME_DRIVER;
    }

    public static String getPathToFirefoxDriver() {
        return PATH_TO_FIREFOX_DRIVER;
    }

    public static String getLOGIN() {
        return LOGIN;
    }

    public static String getURL() {
        return URL;
    }

    public static String getBROWSER() {
        return BROWSER;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    static {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream(new File(PATH_TO_PROPERTIES).getAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        URL = props.getProperty("URL");
        LOGIN = props.getProperty("LOGIN");
        PASSWORD = props.getProperty("PASSWORD");
        BROWSER = props.getProperty("BROWSER");
        TIME_DELAY_IMP = Integer.valueOf(props.getProperty("TIME_DELAY_IMP"));
        TIME_DELAY_EXP = Integer.valueOf(props.getProperty("TIME_DELAY_EXP"));
        PATH_TO_CHROME_DRIVER = props.getProperty("PATH_TO_CHROME_DRIVER");
        PATH_TO_FIREFOX_DRIVER = props.getProperty("PATH_TO_FIREFOX_DRIVER");
        PATH_TO_CSV_FILE = props.getProperty("PATH_TO_CSV_FILE");
    }

}
