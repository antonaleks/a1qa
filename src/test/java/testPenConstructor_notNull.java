import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testPenConstructor_notNull {

    @Parameters("inkContainerValue")
    @Test
    public void testPenConstrWithOneParam(int inkContainerValue){
        Assert.assertNotNull(new Pen(inkContainerValue));
    }

    @Parameters({"inkContainerValue","sizeLetter"})
    @Test
    public void testPenConstrWithTwoParam(int inkContainerValue, double sizeLetter){
        Assert.assertNotNull(new Pen(inkContainerValue, sizeLetter));
    }

    @Parameters({"inkContainerValue", "sizeLetter", "color"})
    @Test
    public void testPenConstrWithThreeParam(int inkContainerValue, double sizeLetter, String color) {
        Assert.assertNotNull(new Pen(inkContainerValue, sizeLetter, color));
    }

}
