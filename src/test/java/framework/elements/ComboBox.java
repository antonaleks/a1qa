package framework.elements;

import framework.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ComboBox extends BaseElement {

    public ComboBox(By locator){
        super(locator);
    }

    public void SelectByValue(String value){
        new Select(getElement()).selectByValue(value);
    }

    public void SelectByText(String text){
        new Select(getElement()).selectByVisibleText(text);
    }

    public void waitForSelect(){
        waitForExpretion(new Select(getElement()).getFirstSelectedOption()!=null);
    }

    public void waitForExistOptions(){waitForExpretion(!new Select(getElement()).getOptions().isEmpty());}

    public String getSelectedItem(){
        return new Select(getElement()).getFirstSelectedOption().getText();
    }

    public List<Label> getOptionsList(){
        return getElementList(new Select(getElement()).getOptions());
    }

    public void waitForChangeOptions(By locator){
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


}
