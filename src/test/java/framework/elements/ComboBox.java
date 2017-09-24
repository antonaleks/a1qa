package framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class ComboBox extends BaseElement{

    public ComboBox(By locator){
        super(locator);
    }

    public void SelectByValue(String value){
        new Select(element).selectByValue(value);
    }

}
