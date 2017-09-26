package steam.forms;


import framework.BaseForm;
import org.openqa.selenium.By;


public class DownloadPage extends BaseForm{
    private By chromeDownloadLocator = By.id("progressContainer");
    private By firefoxDownloadLocator = By.xpath("//*[contains(@class,\"download download-state\")]");

    public void waitingForDownloadFile(){
        waitForDownloadFileInBrowser(firefoxDownloadLocator,chromeDownloadLocator);
    }
}
