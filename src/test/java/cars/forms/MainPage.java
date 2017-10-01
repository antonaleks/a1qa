package cars.forms;

import cars.entities.Car;
import cars.forms.elements.TabElement;
import framework.BaseForm;
import framework.elements.Button;
import framework.elements.ComboBox;
import framework.elements.Label;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Random;


public class MainPage extends BaseForm {

    private TabElement tabElement = new TabElement();

    public TabElement getTabElement() {
        return tabElement;
    }

    private ComboBox cmbMakeLocator;
    private ComboBox cmbModelLocator;
    private ComboBox cmbYearLocator;

    private String cmbLocator = "//div[contains(@class,\"%s\")]//select";

    private Button btnSearhLocator = new Button(By.className("hsw-submit"));

    public Button getBtnSearhLocator() {
        return btnSearhLocator;
    }


    public String fillComboBox(ComboBox comboBox, String locator){
        comboBox = new  ComboBox(By.xpath(locator));
        Random ran = new Random();
        //Ждем, пока в комбобоксе не появится список элементов
        comboBox.waitForChangeOptions(By.xpath(locator+"//option[2]"));
        List<Label> cmbOptionList = comboBox.getOptionsList();
        String selectedText = cmbOptionList.get(ran.nextInt(cmbOptionList.size()-2)+1).getText();
        comboBox.SelectByText(selectedText);
        return selectedText;
    }

        public Car fillComboBoxesAndGetCar(){
        String make, model, year;
        //5 попыток выбрать случайную машину (необходимо заполнить все три комбобокса)
        for(int i=0;i<5;i++) {
            try {
                make = fillComboBox(cmbMakeLocator, String.format(cmbLocator, "hsw-makes"));
                model = fillComboBox(cmbModelLocator, String.format(cmbLocator, "hsw-models"));
                year = fillComboBox(cmbYearLocator, String.format(cmbLocator, "hsw-years"));
            } catch (IllegalArgumentException ex) {
                continue;
            }
            return new Car(make, model, year);
        }
        fatal();
        return null;
    }



}
