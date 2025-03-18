package at.tugraz.ist.stracke.jsr;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;

public class ExpintMultiplicationBy1Test {
    public ExpintMultiplicationBy1Test() {
    }
    @Test
    public void expint1() {
        ExpintMultiplicationBy1 expint = new ExpintMultiplicationBy1();
        Assert.assertEquals(true, Math.abs(expint.exe(5, 2.5) - (0.01190737934637797)) < 1e-9);
    }

    @Test
    public void expint2() {
        ExpintMultiplicationBy1 expint = new ExpintMultiplicationBy1();
        Assert.assertEquals(true, Math.abs(expint.exe(1, 10) - (4.1569689211880595e-6)) < 1e-9);
    }
    @Test
    public void expint3() {
        ExpintMultiplicationBy1 expint = new ExpintMultiplicationBy1();
        Assert.assertEquals(true, Math.abs(expint.exe(7, 25) - (4.3684684836002376e-13)) < 1e-14);
    }
    @Test
    public void expint4() {
        ExpintMultiplicationBy1 expint = new ExpintMultiplicationBy1();
        Assert.assertEquals(true, Math.abs(expint.exe(15, 2) - (0.00838980749776144)) < 1e-9);
    }
    @Test
    public void expint5() {
        ExpintDivisionBy1 expint = new ExpintDivisionBy1();
        Assert.assertEquals(true, Math.abs(expint.exe(0, 10) - (4.539992976248485e-06)) < 1e-9);
    }
}