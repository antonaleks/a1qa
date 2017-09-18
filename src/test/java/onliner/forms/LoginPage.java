package onliner.forms;

import framework.PropertiesData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private By usernameLocator = By.xpath("//div[@id='modal-auth']//input[@type='text']");
    private By passwordLocator = By.xpath("//input[@type='password']");
    private By loginButtonLocator = By.xpath("//button[contains(@class,\"auth-box__auth-submit\")]");
    private By homeTitleLocator = By.xpath("//a[@class='auth-top__logo auth__icon auth__icon--logo']");


    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private LoginPage typeUsername(String username) {
        driver.findElement(usernameLocator).sendKeys(username);
        return this;
    }

    private LoginPage typePassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
        return this;
    }

    public UserPage goToUserPage(){
        driver.findElement(loginButtonLocator).submit();
        WebElement myDynamicElement = (new WebDriverWait(driver, PropertiesData.getTimeDelayExp()))
                .until(new ExpectedCondition<WebElement>(){
                    @Override
                    public WebElement apply(WebDriver d) {
                        return d.findElement(loginButtonLocator);
                    }});
        Actions action = new Actions(driver);
        action.moveToElement(myDynamicElement).click(myDynamicElement).build().perform();
        return new UserPage(driver);
    }


    public UserPage loginAs(String username, String password) {
        typeUsername(username);
        typePassword(password);
        return goToUserPage();
    }

    public HomePage goToHomePage() {
        driver.findElement(homeTitleLocator).click();
        return new HomePage(driver);
    }

}
