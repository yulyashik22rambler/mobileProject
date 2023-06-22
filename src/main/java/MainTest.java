import org.junit.Assert;
import org.junit.Test;

public class MainTest {

    @Test
    public void getLocalNumber() {
        MainClass mainClass = new MainClass();
        Assert.assertEquals("Result of mainClass.getLocalNumber() should be 14",
                14, mainClass.getLocalNumber());
    }

    @Test
    public void testGetClassNumber() {
        MainClass mainClass = new MainClass();
        Assert.assertTrue("Result of mainClass.getLocalNumber() should be more 45",
                 mainClass.getClassNumber()>45);
    }

    @Test
    public void testGetClassString() {
        MainClass mainClass = new MainClass();
        Assert.assertTrue("Method getClassString should contains substring 'hello' or 'Hello'",
                mainClass.getClassString().contains("hello")||mainClass.getClassString().contains("Hello"));
    }
}
