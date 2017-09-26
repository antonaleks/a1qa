package framework;

import framework.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public abstract class BaseEntity {


    @BeforeClass
    public void init() throws IOException {
        BrowserFactory.Initialize();
        BrowserFactory.getInstance().manage().window().maximize();
        navigateToUrl(PropertiesManager.getUrl());
    }


    private WebDriverWait driverWait;

    protected WebDriverWait getDriverWait(){
        if(driverWait==null)driverWait = new WebDriverWait(BrowserFactory.getInstance(),PropertiesManager.getTimeDelayExp());
        return driverWait;
    }

    protected void navigateToUrl(String url){
        BrowserFactory.getInstance().navigate().to(url);
    }
    protected String getPathToDownloadBrowser(){
        String pathToDowloadsBrowse = "%s:downloads";
        switch (PropertiesManager.getBrowser()){
            case "chrome":
                return String.format(pathToDowloadsBrowse,"chrome");
            case "firefox":
                return String.format(pathToDowloadsBrowse,"about");
            default:
                return "";
        }
    }
    protected void waitForDownloadFileInBrowser(By firefoxLocator, By chromeLocator){
        switch (PropertiesManager.getBrowser()){
            case "chrome":
                Label chromeDownloadFile = new Label(chromeLocator);
                waitForExpretion(!chromeDownloadFile.isExist());
                break;
            case "firefox":
                Label firefoxDownloadFile = new Label(firefoxLocator);
                waitForExpretion(firefoxDownloadFile.GetAttribute("state").equals("1"));
                break;
        }
    }
    protected void waitForExpretion(boolean eneabled){
        getDriverWait().until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return eneabled;
            }
        });
    }

    protected void assertEquals(String testValue, String validValue){
        Assert.assertEquals(testValue,validValue);
    }


    @AfterClass
    public void tearDown(){
        BrowserFactory.exit();
    }

}
