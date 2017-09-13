import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testPenIsWork_shouldReturnBool {
    @Parameters({"inkContainerValue","isWork"})
    @Test
    public void testIsWork(int inkContainerValue, Boolean isWork) {
        Assert.assertEquals(new Pen(inkContainerValue).isWork(),isWork);
    }
}
