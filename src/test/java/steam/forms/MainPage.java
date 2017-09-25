package steam.forms;

import framework.BaseForm;
import framework.PropertiesManager;
import framework.elements.Label;
import steam.forms.elements.MenuElement;
import org.openqa.selenium.By;


public class MainPage extends BaseForm{

    private String englishLanguageLocator = "//a[contains(@href,\"?l=%s\")]";
    private Label lblLanguage = new Label(By.id("language_pulldown"));

    private MenuElement menuElement = new MenuElement();

    public MenuElement getMenuElement() {
        return menuElement;
    }

    public MainPage() {
        super(By.xpath("//div[contains(@class,\"home_page_content\")]/h2"));
    }
    public void checkLanguage(String language){
        if(PropertiesManager.getLanguage().equals(language)){
            lblLanguage.clickAndWait();
            new Label(By.xpath((String.format(englishLanguageLocator, PropertiesManager.getLanguage())))).clickAndWait();
        }
    }

}
