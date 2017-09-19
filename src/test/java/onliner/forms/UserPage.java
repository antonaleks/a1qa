package onliner.forms;

import com.google.common.base.Function;
import framework.PropertiesData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class UserPage {

    private final WebDriver driver;

    private By menuWithLogOutLocator = By.cssSelector("div.b-top-profile__image");
    private By exitLinkLocator = By.xpath("//a[contains(@href,\"https://profile.onliner.by/logout\")]");

    public UserPage(WebDriver driver) {
        this.driver = driver;

    }

    public LoginPage loginOut() {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(PropertiesData.getTimeDelayExp(), TimeUnit.SECONDS)
                .pollingEvery(PropertiesData.getTimeDelayImp(), TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement exitLink = wait.until(new Function<WebDriver, WebElement>() { 	public WebElement apply(WebDriver driver) {
            return driver.findElement(menuWithLogOutLocator);
        }
        });
        exitLink.click();
        driver.findElement(exitLinkLocator).click();
        return new LoginPage(driver);
    }

}
