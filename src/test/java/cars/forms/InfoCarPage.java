package cars.forms;

import cars.forms.elements.CarResearchMenuElement;
import framework.BaseForm;
import framework.elements.Label;
import org.openqa.selenium.By;

public class InfoCarPage extends BaseForm{
    private CarResearchMenuElement carResearchMenuElement = new CarResearchMenuElement();
    private Label lblLinkToCar = new Label(By.xpath("//div[contains(@id,'mmy-trims')]//a"));

    public Label getLblLinkToCar() {
        lblLinkToCar.waitForAjax();
        return lblLinkToCar;
    }

    public InfoCarPage(){
        super(By.xpath("//div[@id='mmy-trims']//a"));
    }

    public CarResearchMenuElement getCarResearchMenuElement() {
        return carResearchMenuElement;
    }

}
