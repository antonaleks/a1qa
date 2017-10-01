package cars.forms.elements;


import framework.elements.Label;
import org.openqa.selenium.By;

public class TopMenuElement {

    private String topMenuItemLocator = "//a[contains(@class,\"nav-item-menu\") and contains(@menu-name,\"%s\")]";
    private String secondLevelItemLocator = "//div[contains(@class,\"container\")]//a[contains(text(),\"%s\")]";
    public enum TopLevelMenuItem{
        BUY("Buy"),
        SELL_AND_TRADE("Sell"),
        SERVICES_AND_REPAIR("Service"),
        VIDEOS_AND_REVIEWS("News Landing Page");
        private String name;

        TopLevelMenuItem(String text) {
            this.name = text;
        }

        public String getName() {
            return this.name;
        }
    }
    public TopMenuElement(){
    }
    public void navigate(TopLevelMenuItem topItem,String subItem){
        new Label(By.xpath(String.format(topMenuItemLocator,topItem.getName()))).updateAndClick();
        new Label(By.xpath(String.format(secondLevelItemLocator,subItem))).updateAndClick();
    }

}
