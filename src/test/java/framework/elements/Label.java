package framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Label extends BaseElement{
    public Label(By locator){
        super(locator);
    }

    protected Label (WebElement element){
        super(element);
    }

    public List<Label> getLabelList(){
        return getElementList(getWebElementList());
    }
}
