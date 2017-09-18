package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Driver {

    public static WebDriver Instance = null;

    public static void Initialize() throws IOException {
        if(Instance == null){
            if(PropertiesData.getBROWSER().equals("firefox")){
                System.setProperty("webdriver.gecko.driver", PropertiesData.getPathToFirefoxDriver());
                Instance = new FirefoxDriver();
            }
            else if(PropertiesData.getBROWSER().equals("chrome")){
                System.setProperty("webdriver.chrome.driver", PropertiesData.getPathToChromeDriver());
                Instance = new ChromeDriver();
            }
            else if(PropertiesData.getBROWSER().equals("ie")){
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
