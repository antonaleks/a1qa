package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public abstract class BaseEntity {


    @BeforeClass
    public void init() throws IOException {
        BrowserFactory.Initialize();
        BrowserFactory.getInstance().manage().window().maximize();
        BrowserFactory.getInstance().navigate().to(PropertiesManager.getUrl());
    }


    private WebDriverWait driverWait;

    protected WebDriverWait getDriverWait(){
        if(driverWait==null)driverWait = new WebDriverWait(BrowserFactory.getInstance(),PropertiesManager.getTimeDelayExp());
        return driverWait;
    }

    public void waitForFileDownload( String expectedFileName) throws IOException {
        FluentWait<WebDriver> wait = new FluentWait(BrowserFactory.getInstance())
                .withTimeout(PropertiesManager.getTimeDelayExp(), TimeUnit.SECONDS)
                .pollingEvery(PropertiesManager.getTimeDelayImp(), TimeUnit.SECONDS);
        File fileToCheck = new File(expectedFileName);

        wait.until((WebDriver wd) -> fileToCheck.exists());

    }


    public void assertEquals(String testValue, String validValue){
        Assert.assertEquals(testValue,validValue);
    }


    @AfterClass
    public void tearDown(){
        BrowserFactory.exit();
    }

}
