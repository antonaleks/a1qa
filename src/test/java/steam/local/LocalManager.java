package steam.local;

import framework.PropertiesManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LocalManager {
    private static String menuGames;
    private static String menuYourStore;
    private static String menuSoftware;
    private static String menuHardware;
    private static String menuVideos;
    private static String menuNews;

    private static String menuGamesAction;

    private static String actionPageDetect;

    public static String getActionPageDetect() {
        return actionPageDetect;
    }

    private static String pathToLanguageProperties = "src/test/resources/%s.properties";

    public static String getMenuVideos() {
        return menuVideos;
    }

    public static String getMenuNews() {
        return menuNews;
    }

    public static String getMenuYourStore() {
        return menuYourStore;
    }

    public static String getMenuSoftware() {
        return menuSoftware;
    }

    public static String getMenuHardware() {
        return menuHardware;
    }

    public static String getMenuGamesAction() {
        return menuGamesAction;
    }

    public static String getMenuGames() {
        return menuGames;
    }

    static{
        Properties propsLang = new Properties();
        try {
            propsLang.load(new FileInputStream(new File(String.format(pathToLanguageProperties, PropertiesManager.getLanguage())).getAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        menuGames =  propsLang.getProperty("menuGames");
        menuHardware = propsLang.getProperty("menuHardware");
        menuSoftware = propsLang.getProperty("menuSoftware");
        menuYourStore = propsLang.getProperty("menuYourStore");
        menuVideos = propsLang.getProperty("menuVideos");
        menuNews = propsLang.getProperty("menuNews");
        menuGamesAction =  propsLang.getProperty("menuGamesAction");
        actionPageDetect = propsLang.getProperty("actionPageDetect");

    }
}
