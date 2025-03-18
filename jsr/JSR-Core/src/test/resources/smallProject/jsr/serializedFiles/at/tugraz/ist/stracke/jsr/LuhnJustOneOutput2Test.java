package at.tugraz.ist.stracke.jsr;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;

public class LuhnJustOneOutput2Test {

    public LuhnJustOneOutput2Test() {
    }
    @Test
    public void luhnShouldFail1() {
        LuhnJustOneOutput2 luhn = new LuhnJustOneOutput2();
        Assert.assertEquals(1, luhn.validate("5114595121210620",0));
    }
    @Test
    public void luhn1() {
        LuhnJustOneOutput2 luhn = new LuhnJustOneOutput2();
        Assert.assertEquals(0, luhn.validate("5114595121210621",0));
    }
    @Test
    public void luhnShouldFail2() {
        LuhnJustOneOutput2 luhn = new LuhnJustOneOutput2();
        Assert.assertEquals(0, luhn.validate("511459512121062",0));
    }
    @Test
    public void luhn2() {
        LuhnJustOneOutput2 luhn = new LuhnJustOneOutput2();
        Assert.assertEquals(1, luhn.validate("4436124776766770",1));
    }
    @Test
    public void luhn3() {
        LuhnJustOneOutput2 luhn = new LuhnJustOneOutput2();
        Assert.assertEquals(1, luhn.validate("4436128683271576",1));
    }
    @Test
    public void luhn4() {
        LuhnJustOneOutput2 luhn = new LuhnJustOneOutput2();
        Assert.assertEquals(0, luhn.validate("5114595121210620",1));
    }
    @Test
    public void luhn5() {
        LuhnJustOneOutput2 luhn = new LuhnJustOneOutput2();
        Assert.assertEquals(0, luhn.validate("511459512121",1));
    }

}