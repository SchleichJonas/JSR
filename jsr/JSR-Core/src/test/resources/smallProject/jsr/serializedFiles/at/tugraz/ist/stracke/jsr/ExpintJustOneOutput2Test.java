package at.tugraz.ist.stracke.jsr;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;

public class ExpintJustOneOutput2Test {
    public ExpintJustOneOutput2Test() {
    }
    @Test
    public void expint1() {
        ExpintJustOneOutput2 expint = new ExpintJustOneOutput2();
        Assert.assertEquals(true, Math.abs(expint.exe(5, 2.5) - (0.01190737934637797)) < 1e-9);
    }

    @Test
    public void expint2() {
        ExpintJustOneOutput2 expint = new ExpintJustOneOutput2();
        Assert.assertEquals(true, Math.abs(expint.exe(1, 10) - (4.1569689211880595e-6)) < 1e-9);
    }
    @Test
    public void expint3() {
        ExpintJustOneOutput2 expint = new ExpintJustOneOutput2();
        Assert.assertEquals(true, Math.abs(expint.exe(7, 25) - (4.3684684836002376e-13)) < 1e-14);
    }
    @Test
    public void expint4() {
        ExpintJustOneOutput2 expint = new ExpintJustOneOutput2();
        Assert.assertEquals(true, Math.abs(expint.exe(15, 2) - (0.00838980749776144)) < 1e-9);
    }
    @Test
    public void expint5() {
        ExpintDivisionBy1 expint = new ExpintDivisionBy1();
        Assert.assertEquals(true, Math.abs(expint.exe(0, 10) - (4.539992976248485e-06)) < 1e-9);
    }
}