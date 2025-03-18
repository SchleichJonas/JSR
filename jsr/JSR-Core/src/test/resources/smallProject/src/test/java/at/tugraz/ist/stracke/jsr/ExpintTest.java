package at.tugraz.ist.stracke.jsr;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;

public class ExpintTest {

    public ExpintTest() {
    }
    @Test
    public void expint1() {
        Expint.exe(5, 2.5);
        Assert.assertEquals(true, Math.abs(Expint.result - (0.01190737934637797)) < 1e-9);
    }
    @Test
    public void expint2() {
        Expint.exe(5, 2.5);
        Assert.assertEquals(true, Math.abs(Expint.del - (1.0000000545697552)) < 1e-9);
    }

    @Test
    public void expint3() {
        Expint.exe(1, 10);
        Assert.assertEquals(true, Math.abs(Expint.result - (4.1569689211880595e-6)) < 1e-9);
    }
    @Test
    public void expint4() {
        Expint.exe(1, 10);
        Assert.assertEquals(true, Math.abs(Expint.del - (1.0000000211235915)) < 1e-9);
    }

    @Test
    public void expint5() {
        Expint.exe(7, 25);
        Assert.assertEquals(true, Math.abs(Expint.result - (4.3684684836002376e-13)) < 1e-14);
    }
    @Test
    public void expint6() {
        Expint.exe(7, 25);
        Assert.assertEquals(true, Math.abs(Expint.del - (1.0000000482991784)) < 1e-9);
    }

    @Test
    public void expint7() {
        Expint.exe(15, 2);
        Assert.assertEquals(true, Math.abs(Expint.result - (0.00838980749776144)) < 1e-9);
    }
    @Test
    public void expint8() {
        Expint.exe(15, 2);
        Assert.assertEquals(true, Math.abs(Expint.del - (1.0000000814659802)) < 1e-9);
    }

    @Test
    public void expint9() {
        Expint.exe(0, 10);
        Assert.assertEquals(true, Math.abs(Expint.result - (4.539992976248485e-06)) < 1e-9);
    }
    @Test
    public void expint10() {
        Expint.exe(0, 10);
        Assert.assertEquals(true, Math.abs(Expint.del - (0.0)) < 1e-9);
    }
}
