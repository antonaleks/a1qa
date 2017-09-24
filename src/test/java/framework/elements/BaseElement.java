package framework.elements;

import framework.BaseEntity;
import framework.BrowserFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public abstract class BaseElement extends BaseEntity{

    private By locator;
    protected WebElement element;

    public BaseElement(By locator){
        this.locator = locator;
        if(isExist())this.element = BrowserFactory.getInstance().findElement(locator);
    }
    protected BaseElement(WebElement element){
        this.element=element;
    }



    public String getText() {
        return element.getText();
    }

    public String waitAndGetText(){
        getDriverWait().until(ExpectedConditions.elementToBeClickable(locator));
        return element.getText();
    }

    public void sendKeys(String input){
        element.sendKeys(input);
    }

    public boolean isEneabled(){
        return element.isEnabled();
    }
    public boolean isSelected(){
        return element.isSelected();
    }
    public boolean isDisplayed(){
        return element.isDisplayed();
    }
    public boolean isExist(){
        return !BrowserFactory.getInstance().findElements(locator).isEmpty();
    }
    public void clickAndWait(){
        element.click();
    }
    public void waitAndClick(){
        getDriverWait().until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    public void clickViaJS(){
        JavascriptExecutor executor = (JavascriptExecutor)BrowserFactory.getInstance();
        executor.executeScript("arguments[0].click();", element);
    }
    public void moveMouseToElement(){
        Actions action = new Actions(BrowserFactory.getInstance());
        action.moveToElement(element).build().perform();
    }
    protected List<WebElement> getWebElementList(){
        return BrowserFactory.getInstance().findElements(locator);
    }
    public void waitForClickable(){
        getDriverWait().until(ExpectedConditions.elementToBeClickable(element));
    }
    public void waitForAjax(){
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


}
