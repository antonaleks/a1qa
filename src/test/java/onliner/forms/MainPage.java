package onliner.forms;

import com.google.common.base.Function;
import framework.PropertiesData;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.*;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainPage {
    private final WebDriver driver;

    private By loginButtonLocator = By.xpath("//div[text()='Вход ']");
    private By navigationLinkListLocator = By.className("project-navigation__link");
    private By navigationTextListLocator = By.className("project-navigation__sign");

    private static String pathToCsvFile = "src/test/resources/";

    public MainPage(WebDriver driver) {

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



    public ProductPage goToRandomProductPage(){
        Random ran = new Random();
        List<WebElement> navigationLinkList = driver.findElements(navigationLinkListLocator);
        List<WebElement> navigationTextList = driver.findElements(navigationTextListLocator);
        int index, iteration = 0;
        do{
        index = ran.nextInt(navigationLinkList.size()-1);
        if(iteration++>=20) Assert.fail();
        } while(!navigationLinkList.get(index).isEnabled() || iteration<20);
        String s = navigationTextList.get(index).getText();
        navigationLinkList.get(index).getAttribute("href");
        navigationLinkList.get(index).click();


        return new ProductPage(driver, s);
    }

    public void getOpinions() throws IOException {
        String pattern = "(?<=<div\\sclass=\"b-opinions-main-2__text\">).+(?=</div>)";
        String text = driver.getPageSource();
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(pathToCsvFile+PropertiesData.getNameFileCSV()), "UTF8"));
        while (m.find()) {
            bw.write(m.group()+"\n");
        }
        bw.flush();

    }



}
