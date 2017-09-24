package steam.forms;

import framework.BaseForm;
import framework.elements.ComboBox;
import framework.elements.Label;
import org.openqa.selenium.By;

public class CheckAgePage extends BaseForm{

    private static String cmbIdLocator = "ageYear";
    private ComboBox cmbSelectYear =  new ComboBox(By.id(cmbIdLocator));
    private Label lblEntry =  new Label(By.xpath("//form//span"));

    public CheckAgePage(){
        super(By.id(cmbIdLocator));
    }


    public void chouseValidYear(){
        if(pageIsPresent) {
           cmbSelectYear.SelectByValue("1998");
           lblEntry.clickAndWait();
        }
    }
}
