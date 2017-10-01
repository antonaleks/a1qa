package cars.forms.elements;

import framework.BaseForm;
import framework.elements.Label;
import org.openqa.selenium.By;

public class CarResearchMenuElement extends BaseForm{
    private String topLevelItemLocator = "//a[contains(@data-linkname,\"%s\")]";

    public enum CarResearchMenuItem{
        OUR_TAKE("our-take-jump"),
        REVIEWS("reviews-jump"),
        TRIMS("trims-jump"),
        GALLERY("gallery-jump"),
        SAFETY("safety-jump"),
        WARRANTLY("warranty-jump");
        private String name;

        CarResearchMenuItem(String text) {
            this.name = text;
        }

        public String getName() {
            return this.name;
        }
    }
    public void navigate(CarResearchMenuItem menuItem){
        Label trimLocator = new Label(By.xpath(String.format(topLevelItemLocator,menuItem.getName())));
        trimLocator.waitAndClick();
    }
}
