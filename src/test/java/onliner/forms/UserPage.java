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

    private By menuWithLogOutLocator = By.xpath("//div[@id='userbar']//a[contains(@class,\"b-top-profile__preview\")]");
    private By exitLinkLocator = By.xpath("//div[@class='b-top-actions']" +
            "//div[@class='b-top-profile__part b-top-profile__part_2']" +
            "//a[@class='b-top-profile__link b-top-profile__link_secondary']");

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
