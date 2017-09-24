package steam.forms.elements;

import framework.elements.Label;
import org.openqa.selenium.By;

public class TabElement {



    public enum TabItem{
        NEW_AND_TRANDING("tab_select_PopularNewReleases"),
        TOP_SELLERS("tab_select_TopSellers"),
        SPECIALS("tab_select_Discounts"),
        NEW_REALESES("tab_select_NewReleases");
        private String id;

        TabItem(String id) {
            this.id = id;
        }

        public String getId() {
            return this.id;
        }
    }
    public TabElement(){
    }
    public void openTabItem(TabItem tabItem){
        new Label(By.id(tabItem.getId())).clickViaJS();
    }

}
