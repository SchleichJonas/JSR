package at.tugraz.ist.stracke.jsr;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;

public class LuhnTest {

    public LuhnTest() {
    }
    @Test
    public void luhnShouldFail1() {
        Luhn luhn = new Luhn();
        Assert.assertEquals(1, luhn.validate("5114595121210620",0));
    }
    @Test
    public void luhn1() {
        Luhn luhn = new Luhn();
        Assert.assertEquals(0, luhn.validate("5114595121210621",0));
    }
    @Test
    public void luhnShouldFail2() {
        Luhn luhn = new Luhn();
        Assert.assertEquals(0, luhn.validate("511459512121062",0));
    }
    @Test
    public void luhn2() {
        Luhn luhn = new Luhn();
        Assert.assertEquals(1, luhn.validate("4436124776766770",1));
    }
    @Test
    public void luhn3() {
        Luhn luhn = new Luhn();
        Assert.assertEquals(1, luhn.validate("4436128683271576",1));
    }
    @Test
    public void luhn4() {
        Luhn luhn = new Luhn();
        Assert.assertEquals(0, luhn.validate("5114595121210620",1));
    }
    @Test
    public void luhn5() {
        Luhn luhn = new Luhn();
        Assert.assertEquals(0, luhn.validate("511459512121",1));
    }

}
