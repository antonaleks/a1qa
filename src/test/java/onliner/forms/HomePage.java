package onliner.forms;

import au.com.bytecode.opencsv.CSVWriter;
import com.google.common.base.Function;
import framework.PropertiesData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomePage {
    private final WebDriver driver;

    private By loginButtonLocator = By.xpath("//div[@class='b-top-actions']" +
            "//div[@class='auth-bar__item auth-bar__item--text']");

    private By navigationLinkListLocator = By.className("project-navigation__link");
    private By navigationTextListLocator = By.className("project-navigation__sign");

    public HomePage(WebDriver driver) {

        this.driver = driver;

    }

    public LoginPage loginIn() {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(PropertiesData.getTimeDelayExp(), TimeUnit.SECONDS)
                .pollingEvery(PropertiesData.getTimeDelayImp(), TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement loginButton = wait.until(new Function<WebDriver, WebElement>() { 	public WebElement apply(WebDriver driver) {
            return driver.findElement(loginButtonLocator);
        }
        });
        loginButton.click();
        return new LoginPage(driver);
    }

    public List<WebElement> getNavigationLinkList(){
        return driver.findElements(navigationLinkListLocator);
    }

    public List<WebElement> getNavigationTextList(){
        return driver.findElements(navigationTextListLocator);
    }

    public ProductPage goToRandomProductPage(){
        Random ran = new Random();
        List<WebElement> navigationLinkList = getNavigationLinkList();
        List<WebElement> navigationTextList = getNavigationTextList();

        final int index = ran.nextInt(navigationLinkList.size()-1);
        String s = navigationTextList.get(index).getText();
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(PropertiesData.getTimeDelayExp(), TimeUnit.SECONDS)
                .pollingEvery(PropertiesData.getTimeDelayImp(), TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement typeOfProguctLink = wait.until(new Function<WebDriver, WebElement>() { 	public WebElement apply(WebDriver driver) {
            return getNavigationLinkList().get(index);
        }
        });
        typeOfProguctLink.click();
        return new ProductPage(driver, s);
    }

    public void getOpinions() throws IOException {
        String pattern = "(?<=<div\\sclass=\"b-opinions-main-2__text\">).+(?=</div>)";
        String text = driver.getPageSource();
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text);
        CSVWriter writer = new CSVWriter(new FileWriter(PropertiesData.getPathToCsvFile()));
        String opinions="";
        while (m.find()) {
            opinions+=m.group() + "#";
        }
        writer.writeNext(opinions.split("#"));
        writer.close();

    }



}
