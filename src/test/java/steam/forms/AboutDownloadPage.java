package steam.forms;

import framework.BaseForm;
import framework.elements.Button;
import org.openqa.selenium.By;

import java.io.IOException;

public class AboutDownloadPage extends BaseForm{
    public AboutDownloadPage(){
        super(By.id("about_install_steam_link"));
    }
    private Button lblDownloadFile = new Button(By.id("about_install_steam_link"));

    public void downloadFile() throws IOException {
        lblDownloadFile.waitAndClick();
        navigateToUrl(getPathToDownloadBrowser());
    }
}
