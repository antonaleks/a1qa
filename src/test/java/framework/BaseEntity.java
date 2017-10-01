package framework;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import framework.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public abstract class BaseEntity {




    private WebDriverWait driverWait;

    protected WebDriverWait getDriverWait(){
        if(driverWait==null)driverWait = new WebDriverWait(BrowserFactory.getInstance(), PropertiesManager.getTimeDelayExp());
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
    protected String getUrl(){
        return BrowserFactory.getInstance().getCurrentUrl();
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
    protected void fluentWaintForExpretion(boolean eneabled){
        new FluentWait<WebDriver>(BrowserFactory.getInstance())
                .withTimeout(PropertiesManager.getTimeDelayExp(), TimeUnit.SECONDS)
                .pollingEvery(PropertiesManager.getTimeDelayImp(), TimeUnit.MILLISECONDS)
                .until(new Function<WebDriver, Boolean>() {

                    public Boolean apply(WebDriver d) {
                        return eneabled;
                    }
                });
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

    public static void softAssertEquals(String testValue, String validValue){
        new SoftAssert().assertEquals(testValue,validValue);
    }
    protected void fatal(){
        Assert.fail();
    }

}
