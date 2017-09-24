package steam.forms;

import framework.BaseForm;
import framework.elements.Label;
import javafx.scene.control.Tab;
import org.openqa.selenium.By;
import steam.forms.elements.TabElement;
import steam.local.LocalManager;

import java.util.List;


public class ActionPage extends BaseForm{
    private TabElement tabControl = new TabElement();
    private String discountListLocator = "//div[@id='DiscountsRows']//div[contains(@class,\"discount_pct\")]";
    private String priceListLocator = "//div[@id='DiscountsRows']//div[contains(@class,\"discount_final_price\")]";
    private String betterDiscount;
    private String betterPrice;

    public String getBetterPrice() {
        return betterPrice;
    }

    public String getBetterDiscount() {
        return betterDiscount;
    }

    public TabElement getTabControl() {
        return tabControl;
    }

    public ActionPage(){
        super(By.xpath("//div[contains(@class,\"responsive_local_menu\")]//a//span"),LocalManager.getActionPageDetect());
    }
    private int getIntDiscount(String discount){
        return Integer.parseInt(discount.substring(1,discount.length()-1));
    }
    public void goToProductWithMaxDiscount(){
        new Label(By.xpath(discountListLocator)).waitForAjax();
        List<Label> discountList = new Label(By.xpath(discountListLocator)).getLabelList();
        List<Label> priceList = new Label(By.xpath(priceListLocator)).getLabelList();
        int maxIndex = 0;
        for(int i = 0;i<discountList.size()-1;i++)
            //Сравниваем скидки без процентов
            if(getIntDiscount(discountList.get(maxIndex).getText())<getIntDiscount(discountList.get(i+1).getText()))maxIndex=i+1;

        betterDiscount = discountList.get(maxIndex).getText();
        betterPrice = priceList.get(maxIndex).getText();
        discountList.get(maxIndex).clickViaJS();
    }


}
