package steam.tests;

import framework.BaseEntity;
import org.testng.annotations.*;
import steam.forms.*;
import steam.forms.elements.MenuElement;
import steam.forms.elements.TabElement;
import steam.local.LocalManager;

import java.io.IOException;

public class TestWebSiteSteam extends BaseEntity{


    @Test
    public void testWebSite() throws IOException, InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.checkLanguage("eng");
        mainPage.getMenuElement().navigate(MenuElement.TopLevelMenuItem.GAMES, LocalManager.getMenuGamesAction());

        ActionPage actionPage = new ActionPage();
        actionPage.getTabControl().openTabItem(TabElement.TabItem.SPECIALS);
        actionPage.goToProductWithMaxDiscount();

        CheckAgePage checkAgePage = new CheckAgePage();
        checkAgePage.chouseValidYear();

        ProductPage productPage = new ProductPage();
        productPage.assertPrice(actionPage.getBetterPrice());
        productPage.assertDiscount(actionPage.getBetterDiscount());
        productPage.getLblDownloadLink().clickAndWait();
        
        DownloadPage downloadPage = new DownloadPage();
        downloadPage.downloadFile();
    }

}
