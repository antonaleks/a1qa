package cars.forms.elements;

import framework.elements.Label;
import org.openqa.selenium.By;

public class TabElement {

    private String tabLocator = "//li[contains(@tab-for,\"%s\")]";

    public enum TabItem{
        CARS_FOR_SALE("inventory"),
        SPECS_AND_REVIEWS("research"),
        SERVICE_AND_DEALERS("dealer"),;
        private String tabFor;

        TabItem(String tabFor) {
            this.tabFor = tabFor;
        }

        public String getTabFor() {
            return this.tabFor;
        }
    }
    public TabElement(){
    }
    public void openTabItem(TabItem tabItem){
        new Label(By.xpath(String.format(tabLocator, tabItem.getTabFor()))).waitAndClick();
    }

}
