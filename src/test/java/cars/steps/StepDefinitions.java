package cars.steps;

import cars.entities.Car;
import cars.forms.*;
import cars.forms.elements.TabElement;
import cars.forms.elements.TopMenuElement;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.BaseEntity;
import framework.BrowserFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StepDefinitions {

    private MainPage mainPage;
    private InfoCarPage infoCarPage;
    private TrimCarPage trimCarPage;
    private CompareCarPage compareCarPage;
    private List<Car> comparableCars = new ArrayList<>();


    @Before
    public void init() throws IOException {
        BrowserFactory.Initialize();
        BrowserFactory.getInstance().manage().window().maximize();
    }

    @Given("^Пользователь переходит на '(.*)'$")
    public void goToUrl(String url){
        BrowserFactory.getInstance().navigate().to(url);
        mainPage = new MainPage();
    }

    @Then("^Переход выполнен успешно на страницу '(.*)'$")
    public void UrlIsCorrect(String url){
        BaseEntity.softAssertEquals(BrowserFactory.getInstance().getCurrentUrl(),url);
    }
    @When("^В поиске выбираем '(.*)'$")
    public void OpenTabItem(String tab){
        mainPage.getTabElement().openTabItem(TabElement.TabItem.valueOf(tab));
    }

    @And("^Заполняем комбобоксы случайным значениями из выпадающих списков$")
    public void fillComboboxesInMainPage(){
        comparableCars.add(mainPage.fillComboBoxesAndGetCar());
    }

    @And("^Кликаем на кнопку Search$")
    public void clickSearch() throws Throwable {
        mainPage.getBtnSearhLocator().updateAndClick();
    }

    @And("^На вкладке Trims переходим по ссылке")
    public void goToTrimAndUrl(){
        infoCarPage = new InfoCarPage();
        infoCarPage.getLblLinkToCar().updateAndClick();
    }

    @And("^Запоминаем характеристики авто №(\\d+) для базового трима последующего сравнения$")
    public void saveCarsCharacteristic(int index){
        trimCarPage = new TrimCarPage();
        trimCarPage.getTrimTable().fillCarCharacteristic(comparableCars.get(--index));
    }


    @When("^Через меню \"([^\"]*)\" переходим по ссылке \"([^\"]*)\"$")
    public void goToMenuItem(String topMenuItem, String menuItem) {
        TopMenuElement topMenuElement = new TopMenuElement();
        topMenuElement.navigate(TopMenuElement.TopLevelMenuItem.valueOf(topMenuItem),menuItem);
    }

    @And("^В разделе Side-by-Side Comparisons переходим по кнопке Compare cars$")
    public void goTOCompareCars(){
        ResearchPage researchPage = new ResearchPage();
        researchPage.getCompareLinkLocator().updateAndClick();
    }

    @And("^Выбираем модель, отобранную на предыдущих шагах и переходим по кнопке Start compare now$")
    public void choseCarAndGoCompare(){
        ChooseFirstCompareCarPage chooseFirstCompareCarPage = new ChooseFirstCompareCarPage();
        chooseFirstCompareCarPage.getFillinigComboboxesForm().fillComboboxes(comparableCars.get(0));
        chooseFirstCompareCarPage.getBtnStartSearchLocator().updateAndClick();
    }

    @And("^Используя Add another car добавляем к сравнению модель авто №(\\d+)$")
    public void addAnotherCar(int index){
        compareCarPage = new CompareCarPage();
        compareCarPage.addNewCar(comparableCars.get(--index));
    }


    @Then("^Характеристики авто на странице соответствуют тем, что получены на предыдущих шагах$")
    public void checkCharacteristic(){
        compareCarPage.checkCharacteristic(comparableCars);
    }

    @After
    public void tearDown(){
        BrowserFactory.exit();
    }

}
