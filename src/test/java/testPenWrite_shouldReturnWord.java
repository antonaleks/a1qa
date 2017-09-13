import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testPenWrite_shouldReturnWord {

    @Parameters({"inkContainerValue", "sizeLetter", "color", "inputWord", "outputWord"})
    @Test
    public void testPenWrite(int inkContainerValue, double sizeLetter, String color, String inputWord, String outputWord) {
        Assert.assertEquals(new Pen(inkContainerValue, sizeLetter, color).write(inputWord),outputWord);
    }

    @Parameters({"inkContainerValue", "sizeLetter", "color", "firstInputWord", "secondInputWord", "secondOutputWord"})
    @Test
    public void testPenWrite_secondUse(int inkContainerValue, double sizeLetter, String color, String firstInputWord, String secondInputWord, String secondOutputWord) {
        Pen pen = new Pen(inkContainerValue, sizeLetter, color);
        pen.write(firstInputWord); //Необходимо в нашем объекте изменить аттрибут inkContainerValue
        Assert.assertEquals(pen.write(secondInputWord),secondOutputWord);
    }
}
