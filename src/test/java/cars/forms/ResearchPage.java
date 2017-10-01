package cars.forms;

import framework.BaseForm;
import framework.elements.Label;
import org.openqa.selenium.By;

public class ResearchPage extends BaseForm{
    private Label compareLinkLocator = new Label(By.xpath("//a[contains(@data-link-name,\"compare-cars\")]"));

    public Label getCompareLinkLocator() {
        return compareLinkLocator;
    }
}
