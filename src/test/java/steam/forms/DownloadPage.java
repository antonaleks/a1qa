package steam.forms;

import framework.BaseForm;
import framework.BrowserFactory;
import framework.elements.Label;
import org.openqa.selenium.By;

import java.io.IOException;

public class DownloadPage extends BaseForm{
    public DownloadPage(){
        super(By.id("about_install_steam_link"));
    }
    private Label lblDownloadFile = new Label(By.id("about_install_steam_link"));
    private String filePath = BrowserFactory.getPathToDownloads()+"\\SteamSetup.exe";

    public void downloadFile() throws IOException {
        lblDownloadFile.waitAndClick();
        waitForFileDownload(filePath);
    }
}
