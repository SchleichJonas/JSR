package at.tugraz.ist.stracke.jsr;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;

public class MiddleJustOneOutputTest {

    public MiddleJustOneOutputTest() {
    }
    @Test
    public void middle1() {
        MiddleJustOneOutput middle = new MiddleJustOneOutput();
        Assert.assertEquals(2, middle.findMiddle(1,2,3));
    }
    @Test
    public void middle2() {
        MiddleJustOneOutput middle = new MiddleJustOneOutput();
        Assert.assertEquals(1, middle.findMiddle(1,1,1));
    }
    @Test
    public void middle3() {
        MiddleJustOneOutput middle = new MiddleJustOneOutput();
        Assert.assertEquals(2, middle.findMiddle(3,2,3));
    }
    @Test
    public void middle4() {
        MiddleJustOneOutput middle = new MiddleJustOneOutput();
        Assert.assertEquals(2, middle.findMiddle(3,2,1));
    }
    @Test
    public void middleShouldFail() {
        MiddleJustOneOutput middle = new MiddleJustOneOutput();
        Assert.assertEquals(3, middle.findMiddle(3,5,1));
    }

}
