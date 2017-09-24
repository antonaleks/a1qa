package steam.forms.elements;


import framework.elements.Label;
import org.openqa.selenium.By;
import steam.local.LocalManager;

public class MenuElement {

    private String topLevelItemLocator = "//a[contains(@class,\"pulldown_desktop\") and contains(text(),\"%s\")]";
    private String secondLevelItemLocator = "//div[@id='genre_flyout']//a[contains(@class,\"popup_menu_item\") and contains(text(),\"%s\")]";

    public enum TopLevelMenuItem{
        YOUR_STORE(LocalManager.getMenuYourStore()),
        GAMES(LocalManager.getMenuGames()),
        SOFTWARE(LocalManager.getMenuSoftware()),
        HARDWARE(LocalManager.getMenuHardware()),
        VIDEOS(LocalManager.getMenuVideos()),
        NEWS(LocalManager.getMenuNews());
        private String name;

        TopLevelMenuItem(String text) {
            this.name = text;
        }

        public String getName() {
            return this.name;
        }
    }
    public MenuElement(){
    }
    public void navigate(TopLevelMenuItem topItem,String subItem){
        new Label(By.xpath(String.format(topLevelItemLocator,topItem.getName()))).moveMouseToElement();
        new Label(By.xpath(String.format(secondLevelItemLocator,subItem))).clickViaJS();
    }

}
