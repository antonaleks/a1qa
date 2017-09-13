
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class testPenDoSomethingElse_PrintColor {

    private File file;

    @BeforeTest
    public void ConnectToStream() throws IOException{
        file = new File("src/test/resources/consoleOutput.txt");
        PrintStream printStream = new PrintStream(file);
        System.setOut(printStream);
    }

    @Parameters({"inkContainerValue", "sizeLetter", "color"})
    @Test
    public void testPenPrintColor(int inkContainerValue, double sizeLetter, String color) throws IOException{
        new Pen(inkContainerValue,sizeLetter,color).doSomethingElse();
        Assert.assertEquals(new Scanner(file).nextLine(), color);
    }

    @AfterTest
    public void teardown() throws IOException{
        System.setOut(System.out);
        file.delete();
    }
}
