package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    private static WebDriver Instance = null;

    public static WebDriver getInstance() {
        return Instance;
    }

    private static String pathToFirefoxDriver = "src/test/resources/geckodriver.exe";
    private static String pathToChromeDriver = "src/test/resources/chromedriver.exe";
    private static String pathToDownloads = "c:\\downloads";


    public static void Initialize() throws IOException {
        if(Instance == null){
            if(PropertiesManager.getBrowser().equals("firefox")){
                System.setProperty("webdriver.gecko.driver", pathToFirefoxDriver);
                FirefoxProfile profile = new FirefoxProfile();
                profile.setPreference("browser.download.folderList",2);
                profile.setPreference("browser.download.dir", pathToDownloads);
                //указываем тип загружаемого файла
                profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/octet-stream");
                FirefoxOptions options = new FirefoxOptions().setProfile(profile);
                Instance = new FirefoxDriver(options);
            }
            else if(PropertiesManager.getBrowser().equals("chrome")){
                System.setProperty("webdriver.chrome.driver", pathToChromeDriver);

                ChromeOptions options = new ChromeOptions();
                Map<String, Object> prefs = new HashMap<String, Object>();
                /*Запускаем браузер в безопасном состоянии, чтобы при скачивании файла не появлялось окно
                *с информацией о том, что файл может заразить компьютер вирусом
                */
                prefs.put("safebrowsing.enabled", "true");
                prefs.put("download.default_directory", pathToDownloads);
                options.setExperimentalOption("prefs", prefs);
                Instance = new ChromeDriver(options);
            }
        }
        Instance.manage().timeouts().implicitlyWait(PropertiesManager.getTimeDelayImp(), TimeUnit.SECONDS);
    }
    public static void exit(){
        Instance.quit();
        Instance = null;
    }


}
