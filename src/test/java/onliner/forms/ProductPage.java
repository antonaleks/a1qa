package onliner.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductPage {
    private final WebDriver driver;

    private By typeLocator = By.tagName("h1");
    private By homeTitleLocator = By.xpath("//a[@href='https://www.onliner.by/']");

    private String comparabaleElement;


    public ProductPage(WebDriver driver, String element) {
        this.driver = driver;
        this.comparabaleElement = element;
    }

    public void compareTypes(){
        if(!driver.findElement(typeLocator).getText().equals(comparabaleElement)){
            Assert.fail();
        }
    }

    public HomePage goToHomePage(){
        driver.findElement(homeTitleLocator).click();
        return new HomePage(driver);
    }
}
