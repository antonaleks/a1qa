package steam.forms;

import framework.BaseForm;
import framework.elements.Label;
import org.openqa.selenium.By;

public class ProductPage extends BaseForm{

    private Label lblDownloadLink = new Label(By.xpath("//a[contains(@class,\"header_installsteam_btn_content\")]"));
    private Label lblPrice = new Label(By.xpath("//div[contains(@class,\"discount_final_price\")]"));
    private Label lblDiscount = new Label(By.xpath("//div[contains(@class,\"discount_pct\")]"));

    public ProductPage(){
        super(By.xpath("//div[contains(@class,\"apphub_OtherSiteInfo\")]//span"));
    }

    public void assertPrice(String price){
        assertEquals(lblPrice.waitAndGetText(),price);
    }

    public void assertDiscount(String discount){
        assertEquals(lblDiscount.waitAndGetText(),discount);
    }

    public Label getLblDownloadLink() {
        return lblDownloadLink;
    }
}

