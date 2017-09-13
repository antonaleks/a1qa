import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testPenWrite_shouldReturnExceptions {


    @Parameters({"inkContainerValue", "sizeLetter", "color", "inputWord", "outputWord"})
    @Test(expectedExceptions = NullPointerException.class)
    public void testPenWrite_NullPointerException(int inkContainerValue, double sizeLetter, String color, String inputWord, String outputWord) {
        Assert.assertEquals(new Pen(inkContainerValue, sizeLetter, color).write(inputWord),outputWord);
    }
}

