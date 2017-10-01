package cars.forms.modals;

import cars.forms.elements.FillinigComboboxesForm;
import framework.elements.Button;
import org.openqa.selenium.By;

public class AnotherCarForm {

    private FillinigComboboxesForm fillinigComboboxesForm = new FillinigComboboxesForm();

    public FillinigComboboxesForm getFillinigComboboxesForm() {
        return fillinigComboboxesForm;
    }

    private Button btnDone = new Button(By.className("modal-button"));

    public Button getBtnDone() {
        return btnDone;
    }
}
