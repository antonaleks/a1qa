package onliner.tests;

import onliner.forms.HomePage;
import onliner.forms.LoginPage;
import onliner.forms.ProductPage;
import onliner.forms.UserPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import framework.Driver;
import framework.PropertiesData;

import java.io.IOException;

public class TestWebSiteOnlinerBy {

    @BeforeTest
    public void init() throws IOException {
        Driver.Initialize();
    }

    @Test
    public void testWebSite() throws  IOException {
        Driver.Instance.navigate().to(PropertiesData.getURL());
        HomePage homePage = new HomePage(Driver.Instance);
        LoginPage loginPage = homePage.loginIn();
        UserPage userPage = loginPage.loginAs(PropertiesData.getLOGIN(),PropertiesData.getPASSWORD());
        loginPage = userPage.loginOut();
        homePage = loginPage.goToHomePage();
        ProductPage productPage = homePage.goToRandomProductPage();
        productPage.compareTypes();
        homePage = productPage.goToHomePage();
        homePage.getOpinions();

    }


    @AfterTest
    public void teardown(){
        Driver.close();
    }

}
