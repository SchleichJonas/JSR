package at.tugraz.ist.stracke.jsr;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;

public class ExpintDivisionBy1Test {
    public ExpintDivisionBy1Test() {
    }
    @Test
    public void expintShouldFail1() {
        ExpintDivisionBy1 expint = new ExpintDivisionBy1();
        Assert.assertEquals(true, Math.abs(expint.exe(5, 2.5) - (0.01190737934637797)) < 1e-9);
    }

    @Test
    public void expintShouldFail2() {
        ExpintDivisionBy1 expint = new ExpintDivisionBy1();
        Assert.assertEquals(true, Math.abs(expint.exe(1, 10) - (4.1569689211880595e-6)) < 1e-9);
    }
    @Test
    public void expintShouldFail3() {
        ExpintDivisionBy1 expint = new ExpintDivisionBy1();
        Assert.assertEquals(true, Math.abs(expint.exe(7, 25) - (4.3684684836002376e-13)) < 1e-14);
    }
    @Test
    public void expintShouldFail4() {
        ExpintDivisionBy1 expint = new ExpintDivisionBy1();
        Assert.assertEquals(true, Math.abs(expint.exe(15, 2) - (0.00838980749776144)) < 1e-9);
    }
}