package framework;

import org.openqa.selenium.By;

public class BaseForm extends BaseEntity{
    protected boolean pageIsPresent;


    public BaseForm(By locator){
        this.pageIsPresent = PageIsPresent(locator);
    }
    public BaseForm(By locator, String formTitle){
        this.pageIsPresent = PageIsPresent(locator,formTitle);
    }
    public boolean PageIsPresent(By locator){
        return !BrowserFactory.getInstance().findElements(locator).isEmpty();
    }
    public boolean PageIsPresent(By locator, String formTitle){
        if(!BrowserFactory.getInstance().findElements(locator).isEmpty())
        return BrowserFactory.getInstance().findElement(locator).getText().equals(formTitle);
        else return false;
    }


}
