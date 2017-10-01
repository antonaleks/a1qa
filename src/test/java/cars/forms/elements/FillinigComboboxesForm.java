package cars.forms.elements;

import cars.entities.Car;
import framework.elements.ComboBox;
import org.openqa.selenium.By;

public class FillinigComboboxesForm {
    private ComboBox cmbMakeLocator = new ComboBox(By.id("make-dropdown"));
    private ComboBox cmbModelLocator = new ComboBox(By.id("model-dropdown"));
    private ComboBox cmbYearLocator = new ComboBox(By.id("year-dropdown"));

    public void fillComboboxes(Car car){
        cmbMakeLocator.SelectByText(car.getMake());
        cmbModelLocator.SelectByText(car.getModel());
        cmbYearLocator.SelectByText(car.getYear());
    }
}
