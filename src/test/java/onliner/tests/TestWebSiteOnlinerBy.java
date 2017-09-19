package onliner.tests;

import onliner.forms.MainPage;
import onliner.forms.LoginPage;
import onliner.forms.ProductPage;
import onliner.forms.UserPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import framework.BrowserFactory;
import framework.PropertiesData;

import java.io.IOException;

public class TestWebSiteOnlinerBy {

    @BeforeTest
    public void init() throws IOException {
        BrowserFactory.Initialize();
    }

    @Test
    public void testWebSite() throws  IOException {
        BrowserFactory.Instance.navigate().to(PropertiesData.getUrl());
        MainPage homePage = new MainPage(BrowserFactory.Instance);
        LoginPage loginPage = homePage.loginIn();
        UserPage userPage = loginPage.loginAs(PropertiesData.getLogin(),PropertiesData.getPassword());
        loginPage = userPage.loginOut();
        homePage = loginPage.goToHomePage();
        ProductPage productPage = homePage.goToRandomProductPage();
        productPage.compareTypes();
        homePage = productPage.goToHomePage();
        homePage.getOpinions();

    }


    @AfterTest
    public void teardown(){
        BrowserFactory.close();
    }

}
