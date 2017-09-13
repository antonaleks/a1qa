import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testPenGetColor_EqualsColor {

    @Parameters({"inkContainerValue", "sizeLetter", "color"})
    @Test
    public void testPenGetColor(int inkContainerValue, double sizeLetter, String color) {
        Assert.assertEquals(new Pen(inkContainerValue, sizeLetter, color).getColor(),color);
    }
}
