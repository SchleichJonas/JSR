package at.tugraz.ist.stracke.jsr;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;

public class MiddleTest {

    public MiddleTest() {
    }
    @Test
    public void middle1() {
        Middle middle = new Middle();
        Assert.assertEquals(2, middle.findMiddle(1,2,3));
    }
    @Test
    public void middle2() {
        Middle middle = new Middle();
        Assert.assertEquals(1, middle.findMiddle(1,1,1));
    }
    @Test
    public void middle3() {
        Middle middle = new Middle();
        Assert.assertEquals(2, middle.findMiddle(3,2,3));
    }
    @Test
    public void middle4() {
        Middle middle = new Middle();
        Assert.assertEquals(2, middle.findMiddle(3,2,1));
    }
    @Test
    public void middleShouldFail() {
        Middle middle = new Middle();
        Assert.assertEquals(3, middle.findMiddle(3,5,1));
    }

}
