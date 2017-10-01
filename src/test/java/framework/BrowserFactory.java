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


    public static void Initialize() throws IOException {
        if(Instance == null){
            if(PropertiesManager.getBrowser().equals("firefox")){
                System.setProperty("webdriver.gecko.driver", pathToFirefoxDriver);
                Instance = new FirefoxDriver();
            }
            else if(PropertiesManager.getBrowser().equals("chrome")){
                System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
                Instance = new ChromeDriver();
            }
        }
        Instance.manage().timeouts().implicitlyWait(PropertiesManager.getTimeDelayImp(), TimeUnit.SECONDS);
        Instance.manage().timeouts().setScriptTimeout(PropertiesManager.getTimeDelayImp(), TimeUnit.SECONDS);
    }
    public static void exit(){
        Instance.quit();
        Instance = null;
    }


}
