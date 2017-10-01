package cars.forms.elements;

import cars.entities.Car;
import framework.elements.Label;
import org.openqa.selenium.By;

import java.util.List;

public class TrimTable {
    private Label baseTrimRowLocator = new Label(By.xpath("//span[contains(@class,\"base-trim-text\")]/../../div"));

    public enum TrimColumnHeader{
        TRIM,
        STARTING_MSPR,
        COMBINED_MPG,
        ENGINE,
        TRANSMISSION,
        DRIVETRAIN,
        EXTERIOR_COLORS,
        SEATS,
        LINKS;
    }

    public void fillCarCharacteristic(Car car){
        List<Label> baseTrimRowList = baseTrimRowLocator.getLabelList();
        car.setEngine(baseTrimRowList.get(TrimColumnHeader.ENGINE.ordinal()).getText());
        car.setTransmission(baseTrimRowList.get(TrimColumnHeader.TRANSMISSION.ordinal()).getText());
    }
}
