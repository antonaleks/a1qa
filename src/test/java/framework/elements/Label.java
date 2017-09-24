package framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Label extends BaseElement{
    public Label(By locator){
        super(locator);
    }

    private Label (WebElement element){
        super(element);
    }

    public List<Label> getLabelList(){
        List<WebElement> WebElemetsList = getWebElementList();
        List<Label> LabelElementsList = new ArrayList<Label>();
        for(WebElement element:WebElemetsList)
            LabelElementsList.add(new Label(element));
        return LabelElementsList;
    }
}
