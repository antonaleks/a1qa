package cars.forms;

import cars.entities.Car;
import cars.forms.modals.AnotherCarForm;
import framework.BaseForm;
import framework.elements.Label;
import org.openqa.selenium.By;

import java.util.List;

public class CompareCarPage extends BaseForm{
    private Label lblAddCarLocator = new Label(By.id("icon-div"));
    private AnotherCarForm anotherCarForm;//диалоговое окно
    private String RowLocator = "//p[contains(text(),\"%s\")]/../..//div[contains(@class,\"info-column\")]//p";



    public void addNewCar(Car car){
        lblAddCarLocator.waitAndClick();
        anotherCarForm = new AnotherCarForm();
        anotherCarForm.getFillinigComboboxesForm().fillComboboxes(car);
        anotherCarForm.getBtnDone().waitAndClick();
    }


    public void checkCharacteristic(List<Car> cars){
        lblAddCarLocator.waitForVisibilityLocator(By.xpath(String.format("//h4[contains(text(),\"%s\")]",cars.get(cars.size()-1).getMake())));
        List<Label> engineRowList = new Label(By.xpath(String.format(RowLocator,"Engine"))).getLabelList();
        List<Label> transmissionRowList = new Label(By.xpath(String.format(RowLocator,"Transmission"))).getLabelList();
        List<Label> nameCarList = new Label(By.tagName("h4")).getLabelList();

        for(int i = 0; i < cars.size(); i++) {
            assertEquals(nameCarList.get(i).getText(), cars.get(i).getYear()+ " " + cars.get(i).getMake() + " " + cars.get(i).getModel());
            String engineCarOfPage = engineRowList.get(i).getText().replace("liter","L");
            String engineCarOfList = cars.get(i).getEngine().replace("liter","L");
            softAssertEquals(engineCarOfPage,engineCarOfList);
            String transmissionCarOfPage = transmissionRowList.get(i).getText().replace("speed","spd");
            String transmissionCarOfList = cars.get(i).getTransmission().replace("speed","spd");
            softAssertEquals(transmissionCarOfPage, transmissionCarOfList);
        }
    }
}
