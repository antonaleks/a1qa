package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    public static WebDriver Instance = null;
    private static String pathToFirefoxDriver = "src/test/resources/geckodriver.exe";
    private static String pathToChromeDriver = "src/test/resources/chromedriver.exe";

    public static void Initialize() throws IOException {
        if(Instance == null){
            if(PropertiesData.getBrowser().equals("firefox")){
                System.setProperty("webdriver.gecko.driver", pathToFirefoxDriver);
                Instance = new FirefoxDriver();
            }
            else if(PropertiesData.getBrowser().equals("chrome")){
                System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
                Instance = new ChromeDriver();
            }
            else if(PropertiesData.getBrowser().equals("ie")){
                Instance = new InternetExplorerDriver();
            }
        }
        Instance.manage().timeouts().implicitlyWait(PropertiesData.getTimeDelayImp(), TimeUnit.SECONDS);
        Instance.manage().window().fullscreen();
    }

    public static void close(){
        Instance.close();
        Instance = null;
    }

    public static void quit(){
        Instance.quit();
        Instance = null;
    }

}
