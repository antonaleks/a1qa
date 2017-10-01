package cars.forms;

import cars.forms.elements.FillinigComboboxesForm;
import framework.BaseForm;
import framework.elements.Button;
import org.openqa.selenium.By;

public class ChooseFirstCompareCarPage extends BaseForm{
    private FillinigComboboxesForm fillinigComboboxesForm = new FillinigComboboxesForm();
    private Button btnStartSearchLocator = new Button(By.className("done-button"));

    public Button getBtnStartSearchLocator() {
        return btnStartSearchLocator;
    }

    public FillinigComboboxesForm getFillinigComboboxesForm() {
        return fillinigComboboxesForm;
    }
}

